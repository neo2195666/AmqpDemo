package com.example.consumermessagedemo.ConsumerServices;

/**
 * Topic交换器
 */

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = "topic-queue-1",autoDelete = "false"),
                    exchange = @Exchange(name = "ex-topic",type = "topic"),
                    key = "log.user.*"
            )
    })
    public void onMessage1(String message){
        System.out.println(message);
    }


    /**
     * #匹配所有
     * @param message
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = "topic-queue-2",autoDelete = "false"),
                    exchange = @Exchange(name = "ex-topic",type = "topic"),
                    key = "#"
            )
    })
    public void onMessage2(String message){
        System.out.println(message);
    }

}
