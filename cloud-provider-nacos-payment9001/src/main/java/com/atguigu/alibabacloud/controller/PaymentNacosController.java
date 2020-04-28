package com.atguigu.alibabacloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunbaojin
 * @date 2020/4/23 21:26
 */
@RestController
public class PaymentNacosController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/test/nacos/{id}")
    public String testNacos(@PathVariable Long id){
        return "========端口："+serverPort+",id:"+id;
    }
}
