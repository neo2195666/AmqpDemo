package com.example.consumermessagedemo.ConsumerServices;

import com.example.messagedemo.pojo.IMessage;
import com.example.messagedemo.pojo.MyMessage;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 自定义消息类型的消费者
 */

@Component
public class MyMessageConsumer {
    /**
     * 消费方法
     * 注解使用 @RabbitListener
     * 创建交换器和队列,并且绑定
     *      注解属性-
     *      @bindings -QueueBinding[],一个QueueBinding代表一个队列和交
     *      换器的绑定规则。包括交换器信息，队列信息，绑定的路由键信息。注解中
     *      的交换器，在RabbitMQ服务器中存在，直接使用；不存在，创建使用。
     *
     *      @QueueBinding注解属性
     *          value（queue类型属性）  队列
     *          exchange（Exchange类型属性，描述一个交换器）      交换器
     *          key（建议使用字母，数字，".",描述队列和交换器的绑定规则,）   路由键
     *
     *      @Queue注解属性
     *      （在RabbitMQ中，队列可以是临时队列，没有消费者的时候，自动删除队列）
     *      我们在web控制台创建的队列是持久|永久队列
     *          name - 队列名字
     *          autoDelete  -默认值""，可选值："true｜false"
     *          key - 路由键
     *
     *      @Exchange注解属性 -
     *          name - 交换器名称
     *          type -  交换器类型，默认direct
     *          autodelete  -   是否自动删除临时交换器。（没有任何队列绑定的时候，自动删除交换器）
     *
     * @param message
     */

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = "direct-mq1",autoDelete = "false"),
                    exchange = @Exchange(name = "ex-direct",autoDelete = "false",type = "direct"),
                    key = {"direct-route-key"}
            )
    })
    public void onMessage(IMessage message){
        if(message instanceof MyMessage) {
            MyMessage myMessage = (MyMessage) message;
            System.out.println(myMessage.getId() + "  ， " + myMessage.getContent());
        }else
            System.out.println("消息类型错误");
    }

}
