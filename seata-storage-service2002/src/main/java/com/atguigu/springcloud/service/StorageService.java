package com.atguigu.springcloud.service;

/**
 * @author sunbaojin
 * @date 2020/4/28 19:02
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
