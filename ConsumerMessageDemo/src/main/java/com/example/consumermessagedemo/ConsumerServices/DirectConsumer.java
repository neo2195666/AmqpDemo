package com.example.consumermessagedemo.ConsumerServices;

/**
 * direct交换器
 */

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class DirectConsumer {

    @Autowired
    private AmqpTemplate template;

    public void directConsumerService(){
        Object o = template.receiveAndConvert("direct-queue-1");
        System.out.println(o);
    }

}
