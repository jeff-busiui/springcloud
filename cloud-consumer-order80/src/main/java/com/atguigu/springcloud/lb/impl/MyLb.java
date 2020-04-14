package com.atguigu.springcloud.lb.impl;

import com.atguigu.springcloud.lb.ILoadBalanced;
import com.netflix.loadbalancer.Server;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunbaojin
 * @date 2020/4/14 12:51
 */
@Slf4j
@Component
public class MyLb implements ILoadBalanced {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance getServer(List<ServiceInstance> reachableServers) {
        int index = getIndexServer() % reachableServers.size();
        return reachableServers.get(index);
    }

    // 获取服务
    public  final int getIndexServer(){
        // 当前下标
        int current ;
        // 下一个数字
        int next;
        do{
            current = atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0: current+1;
        }while (!atomicInteger.compareAndSet(current,next));

        log.info("############当前第"+next+"次调用!");
        return next;
    }


}
