package com.atguigu.springcloud.cntroller;

import com.atguigu.springcloud.service.impl.IMessageProviderImpl;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunbaojin
 * @date 2020/4/23 12:55
 */
@RestController
public class SendMessageController {

    @Resource
    IMessageProviderImpl iMessageProvider;

    @GetMapping(value="/stream/sendMq")
    public String senMessage(){
        return iMessageProvider.senMessage();
    }
}
