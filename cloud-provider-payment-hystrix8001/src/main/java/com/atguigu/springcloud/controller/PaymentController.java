package com.atguigu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunbaojin
 * @date 2020/4/15 8:58
 */
@RestController
@Slf4j
public class PaymentController {


    @GetMapping(value="/payment/hytrix/get_ok")
    public String getPaymentHystrix_ok(){
     return "I am ok ,哈哈哈哈哈哈";
    }

    @GetMapping(value="/payment/hytrix/get_error")
    @HystrixCommand(fallbackMethod = "getPaymentHystrix_error_fallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")})
    public String getPaymentHystrix_error(){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return "I am error,哭哭哭哭";
    }


    public String getPaymentHystrix_error_fallback(){
        return "别哭了，我来了";
    }
}
