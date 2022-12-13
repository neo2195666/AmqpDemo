package com.example.messagesenderdemo.Controller;

import com.example.messagesenderdemo.Services.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmqpController {

    @Autowired
    private AmqpService amqpService;

    @GetMapping("/send")
    public String sendMq(){
        amqpService.sendMq();
        return "消息发送结束";
    }
}
