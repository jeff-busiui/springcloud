package com.atguigu.springdcloud.controller;

import com.atguigu.springdcloud.entities.ConmmonResult;
import com.atguigu.springdcloud.entities.Payment;
import com.atguigu.springdcloud.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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


    @PostMapping(value = "/payment/create")
    @ApiOperation(value = "创建订单接口", notes = "创建订单接口")
    public ConmmonResult create(@ApiParam(required = true, name = "payment", value = "订单的实体对象") Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new ConmmonResult(200, "插入成功", result);
        } else {
            return new ConmmonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    @ApiOperation(value = "查询接口", notes = "根据ID查询数据")
    public ConmmonResult getPaymentById(@ApiParam(required = true, name = "id", value = "订单的id") @PathVariable(value = "id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询数据44444");
        if (payment != null) {
            return new ConmmonResult(200, "查询成功", payment);
        } else {
            return new ConmmonResult(444, "查询不到记录，ID：" + id, null);
        }
    }


}
