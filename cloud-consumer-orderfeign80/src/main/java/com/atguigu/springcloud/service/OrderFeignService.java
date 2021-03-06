package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sunbaojin
 * @date 2020/4/14 19:39
 */
@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE",fallback = OrderFeignFallbackService.class)
public interface OrderFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


    @GetMapping(value="/payment/hytrix/get_ok")
    public String getPaymentHystrix_ok();

    @GetMapping(value="/payment/hytrix/get_error")
    public String getPaymentHystrix_error();
}
