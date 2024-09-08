package com.gauravcoding.dataservice.websocket;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class WebSocketConnection {
    WebSocketStompClient stompClient;

    public WebSocketConnection() throws ExecutionException, InterruptedException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.setDefaultMaxBinaryMessageBufferSize(1024*1024);
        container.setDefaultMaxTextMessageBufferSize(1024*1024);
        WebSocketClient webSocketClient = new StandardWebSocketClient(container);

//        List<Transport> transports = new ArrayList<>(1);
//        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
//
//        SockJsClient sockjsClient = new SockJsClient(transports);

        stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new StringMessageConverter());
        stompClient.setTaskScheduler(new ConcurrentTaskScheduler()); // for heartbeats

        String url = "ws://127.0.0.1:8080/gs-guide-websocket";
        StompSessionHandler sessionHandler = new MyStompSessionHandler();

        StompSession session = stompClient.connect(url, sessionHandler).get();
//
//        session.subscribe("/topic/greetings", new StompFrameHandler() {
//            @Override
//            public Type getPayloadType(StompHeaders headers) {
//                return String.class;
//            }
//
//            @Override
//            public void handleFrame(StompHeaders headers, Object payload) {
//                System.out.println("Received message: " + payload.toString());
//            }
//        });
//
//
//        session.send("/app/hello", "hey");
//
//        System.out.println(webSocketClient);
//        stompClient.send("/topic/something", "payload");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WebSocketConnection webSocketConnection = new WebSocketConnection();
    }
}
