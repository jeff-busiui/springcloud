package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/28 20:50
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping(value="/storage/decrease")
    public void decrease(@RequestParam("productId")Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
    }
}
