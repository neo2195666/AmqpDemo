package com.example.consumermessagedemo.ConsumerServices;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectExchangeConsumerCluster {
    @RabbitListener(queues = {"direct-queue-4"})
    public void onMessage(String message){
        System.out.println("第一个"+message);
    }

    @RabbitListener(queues = {"direct-queue-4"})
    public void onMessage2(String message){
        System.out.println("第二个"+message);
    }

    @RabbitListener(queues = {"direct-queue-4"})
    public void onMessage3(String message){
        System.out.println("第三个"+message);
    }
}
