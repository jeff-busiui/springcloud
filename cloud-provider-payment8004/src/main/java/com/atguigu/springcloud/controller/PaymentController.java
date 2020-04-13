package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/13 14:14
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value="/payment/zk")
    public Payment discover(){
        log.info("zookeeper:"+discoveryClient.getServices());

        Payment payment = new Payment();
        payment.setSerial("99999999");
        return payment;
    }
}
