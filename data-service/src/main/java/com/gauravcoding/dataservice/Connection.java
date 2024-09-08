package com.gauravcoding.dataservice;

import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

public class Connection extends StompSessionHandlerAdapter {

    CountDownLatch shutdownLatch = new CountDownLatch(1);

    public void connect(){



        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new StringMessageConverter());
        stompClient.setTaskScheduler(new DefaultManagedTaskScheduler()); // for heartbeats

        String url = "ws://127.0.0.1:8080/gs-guide-websocket";
        try {
            StompSession session = stompClient.connect(url, this).get();

            session.subscribe("/topic/greetings", this);

            session.send("/app/hello", "Gaurav");
            System.out.println("Sent");


            //Thread.sleep(2000);

            shutdownLatch.await();
            

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("Received: " + payload);
        shutdownLatch.countDown();
    }

}
