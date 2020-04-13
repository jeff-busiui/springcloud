package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunbaojin
 * @date 2020/4/13 14:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainzk80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainzk80.class,args);
    }
}
