package com.example.consumermessagedemo.ConsumerServices;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer {
    /**
     * Fanout 交换器
     * @param message
     */

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = "fanout-queue-1",autoDelete = "false"),
                    exchange = @Exchange(name = "ex-fanout",type = "fanout")
            )
    })
    public void fanoutConsumerTest1(String message){
        System.out.println("fanout-queue-1 => 收到：" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = "fanout-queue-2",autoDelete = "false"),
                    exchange = @Exchange(name = "ex-fanout",type = "fanout")
            )
    })
    public void fanoutConsumerTest2(String message){
        System.out.println("fanout-queue-2 => 收到：" + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = "fanout-queue-3",autoDelete = "false"),
                    exchange = @Exchange(name = "ex-fanout",type = "fanout")
            )
    })
    public void fanoutConsumerTest3(String message){
        System.out.println("fanout-queue-3 => 收到：" + message);
    }
}
