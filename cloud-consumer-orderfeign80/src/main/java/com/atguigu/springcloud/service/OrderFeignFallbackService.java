package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author sunbaojin
 * @date 2020/4/15 12:44
 */
@Component
public class OrderFeignFallbackService implements OrderFeignService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {

        CommonResult<Payment> resultCommon = new CommonResult<Payment>();

        Payment payment = new Payment();
        payment.setSerial("getPaymentById fallback ==============");
        resultCommon.setData(payment);
        return resultCommon;
    }

    @Override
    public String getPaymentHystrix_ok() {
        return "getPaymentHystrix_ok fallback ==============";
    }

    @Override
    public String getPaymentHystrix_error() {
        return "getPaymentHystrix_error fallback ==============";
    }
}
