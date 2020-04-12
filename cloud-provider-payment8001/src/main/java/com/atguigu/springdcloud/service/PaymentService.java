package com.atguigu.springdcloud.service;

import com.atguigu.springdcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunbaojin
 * @date 2020/4/12 9:27
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id) ;
}
