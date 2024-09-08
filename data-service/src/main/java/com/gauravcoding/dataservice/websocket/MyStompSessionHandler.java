package com.gauravcoding.dataservice.websocket;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println("Connected successfully!");


        session.subscribe("/topic/greetings", this);

        System.out.println("Subscribed!");


        session.send("/app/hello", "hey");

        session.send("/topic/hello", "hey");

        session.send("/topic/topic/hello", "hey");
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("Received message: " + payload.toString());
    }
}
