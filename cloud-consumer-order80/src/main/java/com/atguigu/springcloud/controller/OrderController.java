package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/12 19:27
 */
@RestController
@EnableSwagger2
@Slf4j
public class OrderController {

    public static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/create")
    @ApiOperation(value = "用户下单", notes = "用户下单的接口")
    public CommonResult<Payment> create(@ApiParam(required = true, name = "payment", value = "下单的信息") Payment payment) {
        log.info("====================");
        log.info(payment.toString());
        return restTemplate.postForObject(URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value="/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@ApiParam(required = true, name = "id", value = "订单id") @PathVariable Long id) {
        return restTemplate.getForObject(URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping(value="/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentByIdEnt(@PathVariable Long id){
        ResponseEntity<CommonResult> repository =  restTemplate.getForEntity(URL+"/payment/get/"+id,CommonResult.class);
        return repository.getBody();
    }
}
