package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JWS
 * @create 2022/8/18 18:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006consul {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006consul.class, args);
    }

}
