package com.gauravCoding.learnKafka;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaAvroProducer {

    public static void main(String[] args){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://localhost:8081");

        KafkaProducer<String, GenericRecord> kafkaProducer = new KafkaProducer<>(properties);

        User user = new User();
        user.setName("Gaurav");
        user.setFavoriteColor("Blue");
        user.setFavoriteNumber(7);

        System.out.println(String.format("User: %s", user));

        String topic = "userTopic";
        ProducerRecord<String, GenericRecord> producerRecord = new ProducerRecord<>(topic, user);

        System.out.println(producerRecord);

        kafkaProducer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if(e == null){
                    System.out.println("Success");
                    System.out.println(recordMetadata.toString());
                }else{
                    e.printStackTrace();
                }
            }
        });

        kafkaProducer.flush();
        kafkaProducer.close();


//        String avroSchema = "{\"type\":\"record\",\"name\":\"User\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"age\",\"type\":\"int\"}]}";
//
//        // Kafka properties
//        Properties props = new Properties();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
//        props.put("schema.registry.url", "http://localhost:8081"); // URL to your Schema Registry
//
//        // Create a Kafka producer
//        Producer<String, GenericRecord> producer = new KafkaProducer<>(props);
//
//        // Create an Avro record
//        Schema.Parser parser = new Schema.Parser();
//        Schema schema = parser.parse(avroSchema);
//        GenericRecord avroRecord = new GenericData.Record(schema);
//        avroRecord.put("name", "John");
//        avroRecord.put("age", 30);
//
//        // Send the Avro record to Kafka topic
//        String topic = "userTopic";
//        ProducerRecord<String, GenericRecord> record = new ProducerRecord<>(topic, avroRecord);
//        producer.send(record);
//
//        // Close the producer
//        producer.close();
    }
}
