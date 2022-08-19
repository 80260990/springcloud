package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author JWS
 * @create 2022/8/15 16:55
 */
@EnableEurekaClient
@SpringBootApplication
//value内的服务名需要大写，小写不生效
@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)  //添加Ribbon客户端，用来换服务的调度算法
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
