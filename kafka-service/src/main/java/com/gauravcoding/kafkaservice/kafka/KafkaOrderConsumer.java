package com.gauravcoding.kafkaservice.kafka;

import com.gauravcoding.dto.Order;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Service
public class KafkaOrderConsumer {
  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;

  @Value("${spring.kafka.properties.schema.registry.url}")
  private String schemaRegistryUrl;

  @Value("${spring.kafka.consumer.group-id-2}")
  private String groupId;

  @Value("${spring.kafka.consumer.auto-offset-reset}")
  private String autoOffsetReset;

  @Value("${spring.kafka.consumer.key-deserializer}")
  private String keyDeserializer;

  @Value("${spring.kafka.consumer.value-deserializer}")
  private String valueDeserializer;

  @Value("${spring.kafka.consumer.topic}")
  private String topicName;

  @PostConstruct
  public void consumeMessages() {
    Properties properties = new Properties();
    properties.put("bootstrap.servers", bootstrapServers);
    properties.put("group.id", groupId);
    properties.put("auto.offset.reset", autoOffsetReset);
    properties.put("key.deserializer", keyDeserializer);
    properties.put("value.deserializer", valueDeserializer);
    properties.put("schema.registry.url", schemaRegistryUrl);
    properties.put("ack-mode", "manual");
    properties.put("enable-auto-commit", false);
    properties.put("specific.avro.reader", true);

    try (Consumer<String, Order> consumer = new KafkaConsumer<>(properties)) {
      consumer.subscribe(Collections.singletonList(topicName));

      // Seek to the beginning of the partition for each assigned partition
      consumer.poll(Duration.ofMillis(1000)); // To ensure the consumer is assigned partitions
      for (TopicPartition partition : consumer.assignment()) {
        consumer.seekToBeginning(Collections.singletonList(partition));
        //consumer.seekToEnd(Collections.singletonList(partition)); // Move to the end
      }

      // Consume messages until all partitions are empty
      boolean allPartitionsEmpty = false;
      while (!allPartitionsEmpty) {
        ConsumerRecords<String, Order> records = consumer.poll(Duration.ofMillis(1000));
        allPartitionsEmpty = true; // Assume all partitions are empty

        for (ConsumerRecord<String, Order> record : records) {
          // Process the record
          System.out.println("Inside consumer received message: " + record.value().toString());
          allPartitionsEmpty = false; // At least one partition has a message
        }
      }

      System.out.println("Exited");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
