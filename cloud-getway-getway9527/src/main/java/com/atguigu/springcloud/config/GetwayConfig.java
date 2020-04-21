package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunbaojin
 * @date 2020/4/16 13:03
 */
@Configuration
public class GetwayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder roues = routeLocatorBuilder.routes();
        // 设置路由
        roues.route("path1",r ->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        roues.route("path2",r ->r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return roues.build();
    }
}
