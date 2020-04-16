package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHytrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/15 8:58
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentHytrixService paymentHytrixService;

    @GetMapping(value="/payment/hytrix/get_ok")
    public String getPaymentHystrix_ok(){
     return paymentHytrixService.getPaymentHystrix_ok();
    }

    @GetMapping(value="/payment/hytrix/get_error")
    public String getPaymentHystrix_error(){return paymentHytrixService.getPaymentHystrix_error(); }


    @GetMapping(value="/payment/hytrix/get_break/{id}")
    public String getHytrixBreak(@PathVariable("id") Long id){
        return paymentHytrixService.getPaymentHytrixBreak(id);
    }


}
