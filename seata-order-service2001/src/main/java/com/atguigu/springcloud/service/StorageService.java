package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sunbaojin
 * @date 2020/4/28 17:23
 */
@FeignClient(value = "seata-storege-service")
public interface StorageService {

    @PostMapping(value="/storage/decrease")
    CommonResult  decrease(@RequestParam("productId")Long productId,@RequestParam("count") Integer count);
}
