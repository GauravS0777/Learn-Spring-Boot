package com.gauravcoding.learnwebsocket;

import com.gauravcoding.learnwebsocket.model.HelloMessage;
import org.junit.jupiter.api.Test;

public class HelloMessageTest {
  @Test
  void getName() {
    HelloMessage message = new HelloMessage("Gauarv Sharma");
    System.out.println(message.getName());
  }
}
