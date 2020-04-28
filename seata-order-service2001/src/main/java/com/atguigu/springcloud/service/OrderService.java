package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sunbaojin
 * @date 2020/4/28 17:15
 */
public interface OrderService {
    // 创建订单
    void create(Order order);
}
