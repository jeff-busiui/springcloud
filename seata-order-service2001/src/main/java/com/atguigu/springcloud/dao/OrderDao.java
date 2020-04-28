package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunbaojin
 * @date 2020/4/28 17:12
 */
@Mapper
public interface OrderDao {
    // 创建订单
    void create(Order order);
    // 更新订单状态为1
    void updateStatus(@Param("userId") Long userId, @Param("status") Integer status);
}
