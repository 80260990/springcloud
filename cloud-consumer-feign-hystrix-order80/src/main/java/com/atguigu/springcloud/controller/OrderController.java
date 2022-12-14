package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JWS
 * @create 2022/8/20 23:44
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired(required = false)
    OrderService orderService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String  paymentInfo_OK(@PathVariable("id") Integer id){
        String result = orderService.paymentInfo_OK(id);
        log.info("***result:"+result);
        return result;

    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = orderService.paymentInfo_TimeOut(id);
        log.info("***result:"+result);
        return result;
    }

}
