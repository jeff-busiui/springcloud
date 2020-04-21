package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunbaojin
 * @date 2020/4/19 12:39
 */
@RestController
@Slf4j
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/config/client/getConfig")
    public String getConfigInfo(){
        return configInfo;
    }
}
