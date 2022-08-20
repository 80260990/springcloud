package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author JWS
 * @create 2022/8/20 23:43
 */
@Service
@EnableFeignClients("CLOUD-PAYMENT-SERVICE")
public interface OrderService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String  paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
