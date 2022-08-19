package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JWS
 * @create 2022/8/18 16:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain80zk {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80zk.class, args);
    }
}
