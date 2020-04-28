package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/28 17:16
 */
@Service
@Slf4j
public class OrdeeServiceImpl implements OrderService {


    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 业务流程
     * 1.下订单
     * 2.扣库存
     * 3.扣价格
     * @param order
     */
    @Override
    @GlobalTransactional(name="fsp_create_order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info(order.toString());

        // 创建订单
        log.info("-------->订单开始创建了");
        orderDao.create(order);
        log.info("-------->订单创建完成了");

        log.info("-------->扣减库存开始了");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("-------->扣减库存完成了");

        log.info("-------->用户账户扣减开始了");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-------->用户账户扣减完成了");

        // 订单状态更新
        log.info("-------->订单状态开始更新了");
        orderDao.updateStatus(order.getUserId(),0);
        log.info("-------->订单状态更新完成了");
    }
}
