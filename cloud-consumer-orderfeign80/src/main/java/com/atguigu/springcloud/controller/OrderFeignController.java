package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.OrderFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/14 19:42
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class OrderFeignController {

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/consumer/payment/getfeign/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id){
        return orderFeignService.getPaymentById(id);
    }

    @GetMapping(value="/consumer/payment/hytrix/get_ok")
    public String getPaymentHystrix_ok(){
        return orderFeignService.getPaymentHystrix_ok();
    }

    @GetMapping(value="/consumer/payment/hytrix/get_error")
    public String getPaymentHystrix_error(){
        return orderFeignService.getPaymentHystrix_error();
    }


    public String getPaymentHystrix_error_fallback(){
        return "我来救你了！！！！";
    }

    public String payment_global_fallbackMethod(){
        return "我是全局的fallback！！！！";
    }

}
