package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunbaojin
 * @date 2020/4/23 22:25
 */
@RestController
@RefreshScope
public class ConfigNacosController {

    @Value("${config.info}")
    String serviceConf;

    @GetMapping(value="/config/nacos/getconfig")
    public String getConfig(){
        return "nacos 读取的配置:"+serviceConf;
    }

}
