package com.example.consumermessagedemo;
/**
 * Maven工程中,启动,编译,打包package,安装install,会执行test包下的所有代码.所以在打包工程前,一定要把test代码注释或者删除
 */

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerMessageDemoApplicationTests {

    @Autowired
    private AmqpTemplate template;

    @Test
    public void directConsumerService(){
        Object o = template.receiveAndConvert("direct-queue-1");
        System.out.println(o);
    }

}
