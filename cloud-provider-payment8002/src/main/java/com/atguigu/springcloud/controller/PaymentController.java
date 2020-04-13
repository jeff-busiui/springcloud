package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/12 9:35
 */
@RestController
@Slf4j
@EnableSwagger2
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @PostMapping(value = "/payment/create")
    @ApiOperation(value = "创建订单接口", notes = "创建订单接口")
    public CommonResult create(@ApiParam(required = true, name = "payment", value = "订单的实体对象") @RequestBody Payment payment) {
        log.info(payment.toString());
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入成功,servicePort:"+servicePort, result);
        } else {
            return new CommonResult(444, "插入数据库失败,servicePort:"+servicePort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    @ApiOperation(value = "查询接口", notes = "根据ID查询数据")
    public CommonResult getPaymentById(@ApiParam(required = true, name = "id", value = "订单的id") @PathVariable(value = "id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info(id.toString());
        if (payment != null) {
            return new CommonResult(200, "查询成功,servicePort:"+servicePort, payment);
        } else {
            return new CommonResult(444, "查询不到记录，ID：" + id+",servicePort:"+servicePort, null);
        }
    }


}
