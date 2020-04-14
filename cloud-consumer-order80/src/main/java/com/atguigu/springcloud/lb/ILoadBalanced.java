package com.atguigu.springcloud.lb;

import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sunbaojin
 * @date 2020/4/14 12:51
 */
@Component
public interface ILoadBalanced  {
    // 获取服务
    ServiceInstance getServer (List<ServiceInstance> reachableServers);
}
