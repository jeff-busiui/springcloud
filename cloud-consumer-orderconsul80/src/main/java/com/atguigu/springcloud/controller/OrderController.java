package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/13 20:42
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://order-proviterconsul-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/order/consul")
    public String orderMent(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
