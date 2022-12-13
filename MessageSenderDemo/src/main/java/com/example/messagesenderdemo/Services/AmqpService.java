package com.example.messagesenderdemo.Services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmqpService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMq(){
        /**
         * 这是异步方法：只发送消息，是否有消费者，是否被消费，都不在意。
         * convertAndSend(交换机，路由健，消息体),
         */
//        for (int i = 0; i < 1000; i++) {
//            amqpTemplate.convertAndSend("ex-direct","direct-route-key","第" + i +"个消息");
//        }

        amqpTemplate.convertAndSend("ex-direct","direct-route-key","第1个消息");
        System.out.println("消息发送结束");
    }
}
