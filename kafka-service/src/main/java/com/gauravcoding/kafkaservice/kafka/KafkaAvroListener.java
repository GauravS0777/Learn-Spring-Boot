package com.gauravcoding.kafkaservice.kafka;

import com.gauravcoding.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroListener {
  @KafkaListener(topics = "${spring.kafka.consumer.topic}")
  public void read(ConsumerRecord<String, Order> consumerRecord, Acknowledgment acknowledgment) {
    String key = consumerRecord.key();
    Order order = consumerRecord.value();
    log.info("Avro message received for key : " + key + " value : " + order.toString());
  }
}
