package com.example.messagesenderdemo;

import com.example.messagedemo.pojo.MyMessage;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class MessageSenderDemoApplicationTests {

    /**
     * Spring AMQP提供的客户端接口类型
     * Spring-boot-starter-amqp启动器会自动创建
     * AmqpTemplate接口实现类对象，RabbitTemplate保存在Spring的容器中
     * 连接的服务器，通过配置文件决定
     */
    @Autowired
    private AmqpTemplate amqpTemplate;
    
    @Test
    public void providerMq(){
        /**
         * Spring AMQP提供的客户端接口类型
         * Spring-boot-starter-amqp启动器会自动创建
         * AmqpTemplate接口实现类对象，RabbitTemplate保存在Spring的容器中
         * 连接的服务器，通过配置文件决定
         * 这是异步方法：只发送消息，是否有消费者，是否被消费，都不在意。
         * convertAndSend(交换机，路由健，消息体),
         */
        amqpTemplate.convertAndSend("ex-direct","direct-route-key",new Date());
        System.out.println("消息发送成功");
    }

    @Test
    public void providerDirect(){

        for (int i = 0; i < 1000; i++) {
            String message = "第" + i + "信息";
            amqpTemplate.convertAndSend("ex-direct","direct-route-key",message);
        }
        System.out.println("消息发送成功");
    }

    @Test
    public void provideMyMsgDirect(){
        MyMessage myMessage = new MyMessage(1,"自定义消息");
        amqpTemplate.convertAndSend("ex-direct","direct-route-key",myMessage);
        System.out.println("自定义消息消息发送成功");
    }

    @Test
    public void fanoutTest(){
        for (int i = 0; i < 100; i++)
            amqpTemplate.convertAndSend("ex-fanout","第" + i + "条数据");
        System.out.println("Fanout交换器测试数据发送完毕");
    }

}
