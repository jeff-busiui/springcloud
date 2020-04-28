package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.block.CommonBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunbaojin
 * @date 2020/4/26 0:08
 */
@RestController
public class SentinelTest2Controller {

    @GetMapping("/testA")
    @SentinelResource(value = "testA",blockHandlerClass = {CommonBlockHandler.class},blockHandler = "handler1")
    public String  testA(){
        return "============== A";
    }
    @GetMapping("/testB")
    @SentinelResource(value = "testB22222222222",blockHandler = "handler_b",fallback = "fallback_b")
    public String  testB(@RequestParam(value = "p1",required = false) String p1,
                         @RequestParam(value = "p2",required = false) String p2){
        int acc= 10/0;
        return "============== B";
    }

    public String  handler_b(String p1, String p2, BlockException ex){
        System.out.println("我异常了===========================");
        return "============== handler_b";
    }

    public String  fallback_b(){
        System.out.println("fallback_b===========================");
        return "============== fallback_b";
    }
}
