package com.example.consumermessagedemo.Controller;

import com.example.consumermessagedemo.Services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String consumer(){
        String o = (String)consumerService.consumerServiceDemo();
        return o;
    }
}
