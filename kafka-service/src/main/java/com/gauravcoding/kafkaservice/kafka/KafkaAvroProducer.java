package com.gauravcoding.kafkaservice.kafka;

import com.gauravcoding.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class KafkaAvroProducer {
    @Value("${spring.kafka.consumer.topic}")
    private String topicName;

    @Autowired
    KafkaTemplate<String, Order> kafkaTemplate;

    @Async
    public void send(Order order){
        log.info("Waiting for sleep to over.") ;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Producing message.") ;
        kafkaTemplate.send(topicName, UUID.randomUUID().toString(), order);
    }
}
