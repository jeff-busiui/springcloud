package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunbaojin
 * @date 2020/4/14 12:36
 */
@Configuration
public class Myrule {

    @Bean
    public IRule getIrule(){
        return new RandomRule();
    }
}
