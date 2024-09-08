package com.gauravcoding.kafkaservice;

import com.gauravcoding.dto.Order;
import com.gauravcoding.kafkaservice.kafka.KafkaAvroProducer;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    KafkaAvroProducer kafkaAvroProducer;


    @PostMapping("/place-order")
    public String placeOrder(@RequestBody Order order){
        order.setTimestamp(Instant.now().toEpochMilli());
        kafkaAvroProducer.send(order);
        return "Order placed";
    }
}
