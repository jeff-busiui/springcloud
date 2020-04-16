package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sunbaojin
 * @date 2020/4/15 12:58
 */
public interface PaymentHytrixService {

    /********************服务降级*********************/
    public String getPaymentHystrix_ok();

    public String getPaymentHystrix_error();

    /********************服务熔断*********************/
    public String getPaymentHytrixBreak(Long id);

}
