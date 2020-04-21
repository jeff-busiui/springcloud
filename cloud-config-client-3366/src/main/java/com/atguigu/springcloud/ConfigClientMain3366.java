package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author sunbaojin
 * @date 2020/4/19 12:27
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366 {
  public static void main(String[] args) {
          SpringApplication.run(ConfigClientMain3366.class,args);
  }
}
