package com.atguigu.springdcloud.service.impl;

import com.atguigu.springdcloud.dao.PaymentDao;
import com.atguigu.springdcloud.entities.Payment;
import com.atguigu.springdcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/12 9:28
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
