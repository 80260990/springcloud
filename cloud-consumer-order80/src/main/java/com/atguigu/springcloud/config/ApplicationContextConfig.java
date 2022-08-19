package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author JWS
 * @create 2022/8/15 17:05
 */
@Configuration
public class ApplicationContextConfig {


    @Bean
//    @LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力，通过微服务名称访问微服务
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
