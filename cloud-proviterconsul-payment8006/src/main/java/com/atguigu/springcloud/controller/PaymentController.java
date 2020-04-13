package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author sunbaojin
 * @date 2020/4/13 20:27
 */
@RestController
@Slf4j
public class PaymentController {

    @GetMapping(value = "/payment/consul")
    public String getPayment(){
        return "consul payment,id:"+ UUID.randomUUID();
    }
}
