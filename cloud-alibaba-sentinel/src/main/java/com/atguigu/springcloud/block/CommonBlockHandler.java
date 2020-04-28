package com.atguigu.springcloud.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author sunbaojin
 * @date 2020/4/26 0:10
 */
public class CommonBlockHandler {

    public static String  handler1(BlockException exception){
        return "============== handler1";
    }

    public static String  handler2(BlockException exception){
        return "============== handler2";
    }
}
