package com.example.consumermessagedemo.Services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private AmqpTemplate template;

    public Object consumerServiceDemo(){
        Object o = template.receiveAndConvert("direct-mq1");
        System.out.println(o);
        return o;
    }

}
