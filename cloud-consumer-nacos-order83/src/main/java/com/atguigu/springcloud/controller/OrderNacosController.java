package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/23 21:50
 */
@RestController
public class OrderNacosController {

    @Resource
    RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    String serverUrl;

    @GetMapping(value="/order/test/nacos/{id}")
    public String orderTestNacos(@PathVariable Long id){
        return restTemplate.getForObject(serverUrl+"/test/nacos/"+id,String.class);
    }

}
