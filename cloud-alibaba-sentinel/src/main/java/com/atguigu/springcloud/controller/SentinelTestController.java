package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author sunbaojin
 * @date 2020/4/25 21:41
 */
@RestController
public class SentinelTestController {

    @GetMapping(value ="/sentinel/test1")
    @SentinelResource
    public String test1(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=================test1111111");
        return "test1";
    }

    @GetMapping(value ="/sentinel/test2")
    @SentinelResource
    public String test2(){
        System.out.println("=================test222222");
        return "test2";
    }

    @GetMapping(value ="/sentinel/test3")
    @SentinelResource
    public String test3(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=================test RT");
        return "test RT";
    }

    @GetMapping(value ="/sentinel/testException")
    public String testSentinelException(){

        int a =10/0;
        System.out.println("=================test testException");
        return "test testException";
    }

    @GetMapping(value ="/sentinel/testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "testHotkey_block")
    public String testHotkey(@RequestParam(value="p1",required = false) String p1){
        System.out.println("=================testHotkey");
        return "testHotkey";
    }

    public String testHotkey_block( String p1,BlockException ex){
        System.out.println("=================testHotkey_block");
        return "testHotkey_block";
    }
}
