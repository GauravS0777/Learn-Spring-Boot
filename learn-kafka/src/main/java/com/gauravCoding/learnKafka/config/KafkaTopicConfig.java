package com.gauravCoding.learnKafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig  {

    @Bean
    public NewTopic getTopic() {
        return TopicBuilder.name("gauravtopic")
                .build();
    }

    @Bean
    public NewTopic getTopic2() {
        return TopicBuilder.name("userTopic")
                .build();
    }
}
