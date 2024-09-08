package com.gauravcoding.dataservice.controller;

import com.gauravcoding.dataservice.dto.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        System.out.println("Got: " + message);
        Thread.sleep(1000); // simulated delay
        return "hello";
    }
}
