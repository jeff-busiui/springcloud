package com.atguigu.springdcloud.dao;

import com.atguigu.springdcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunbaojin
 * @date 2020/4/12 9:07
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id) ;
}
