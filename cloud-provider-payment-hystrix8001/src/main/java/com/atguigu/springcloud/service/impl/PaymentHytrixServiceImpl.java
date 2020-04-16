package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentHytrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sunbaojin
 * @date 2020/4/15 12:59
 */
@Service
@Slf4j
public class PaymentHytrixServiceImpl implements PaymentHytrixService {
    @Override
    public String getPaymentHystrix_ok(){
        return "I am ok ,哈哈哈哈哈哈";
    }
    @Override
    public String getPaymentHystrix_error(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "I am error,哭哭哭哭";
    }

    @HystrixCommand(fallbackMethod = "getHytrixBreak_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    @Override
    public String getPaymentHytrixBreak(Long id) {
        if(id < 0 ){
            throw new RuntimeException("=========我异常了==============");
        }
        return "getHytrixBreak 调用成功==============="+ IdUtil.simpleUUID();
    }

    public String getHytrixBreak_fallback(Long id) {
        log.info("ID 不能为负数===============" + IdUtil.simpleUUID());
        return "ID 不能为负数===============";
    }
}
