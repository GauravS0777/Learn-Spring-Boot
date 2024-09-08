package com.gauravcoding.kafkaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class KafkaServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(KafkaServiceApplication.class, args);
  }
}
