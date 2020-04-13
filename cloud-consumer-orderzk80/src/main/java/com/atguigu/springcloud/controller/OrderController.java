package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/13 14:34
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final  String INIT_URL = "http://cloud-payment-service";

    @GetMapping(value="/consumer/payment/zk")
    public Payment getZk(){

        Payment payment =  restTemplate.getForObject(INIT_URL+"/payment/zk", Payment.class);
        log.info("获取的结果："+payment);
        return payment;
    }
}
