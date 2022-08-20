package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 模仿服务超时，四种情况下进行服务降级:超时，异常，
 * @author JWS
 * @create 2022/8/20 22:20
 */
@Service
public class PaymentService {

    /**
     *
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈";

    }

    /**
     * 模拟超时
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber= 3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut,id:"+id+"\t"+"哈哈哈";
    }

}
