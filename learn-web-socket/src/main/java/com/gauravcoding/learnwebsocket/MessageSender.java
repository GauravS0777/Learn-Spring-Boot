package com.gauravcoding.learnwebsocket;

import com.gauravcoding.learnwebsocket.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
  private final SimpMessagingTemplate messagingTemplate;

  @Autowired
  public MessageSender(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  @Scheduled(fixedRate = 1000) // Send a message every second
  public void sendMessageToTopic() {
    String message = "This is a periodic message from the backend!";
    // messagingTemplate.convertAndSend("/topic/greetings", message);
    Greeting greeting = new Greeting(message);
    messagingTemplate.convertAndSend("/topic/greetings", greeting);
  }
}
