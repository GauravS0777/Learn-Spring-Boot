package com.gauravcoding.learnwebsocket.controller;

import com.gauravcoding.learnwebsocket.model.Greeting;
import com.gauravcoding.learnwebsocket.model.HelloMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class SocketController {

    private static final Logger log = LoggerFactory.getLogger(SocketController.class);
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/topic/{topic}")
    public void subscribeToTopic(@DestinationVariable String topic) {
        log.info("Topic: {}", topic);
    }
}
