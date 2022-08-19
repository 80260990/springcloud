package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author JWS
 * @create 2022/8/15 16:59
 */
@RestController
@Slf4j
public class OrderController
{

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE" ;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("80操作数据库create-8001");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        //return restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    //返回对象为响应体中数据转化成的对象，基本上可以理解为Json
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("80操作数据库getPaymentById");

        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


    //返回对象为ResponseEntity对象，包括了响应中的一些重要信息，比如响应头，响应状态码，响应体等
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentForEntity(@PathVariable("id") Long id){
        log.info("80操作数据getPaymentForEntities-8001");
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getForEntity/" + id, CommonResult.class);
        //判断entity的响应状态码是2xx
        if(entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else{
            return new CommonResult(444,"操作失败");
        }


    }

    /**
     *
     * 默认轮询算法的负载均衡
     * @return
     */
    @GetMapping(value="/consumer/payment/")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances ==null || instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
