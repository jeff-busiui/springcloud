package com.atguigu.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilderFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/23 12:57
 */
@EnableBinding(Source.class) //定义消息的推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String senMessage() {

        String serial = UUID.randomUUID().toString();

        output.send(MessageBuilder.withPayload(serial).build());

        log.info("================send message:" + serial);

        return "发送消息:";
    }
}
