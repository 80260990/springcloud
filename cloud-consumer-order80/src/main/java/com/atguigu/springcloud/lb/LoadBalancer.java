package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author JWS
 * @create 2022/8/19 17:35
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> instances);

}
