package com.atguigu.alibabacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunbaojin
 * @date 2020/4/23 21:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosMain9001 {
    public static void main(String[] args) {
            SpringApplication.run(PaymentNacosMain9001.class,args);
    }
}
