package com.example.kafkawithoutjpa.kafka;

import com.example.kafkawithoutjpa.payload.User;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Configuration
public class JsonKafkaProducer {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(User data)
    {
        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<User> message= MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "springtopic_1")
                .build();
        kafkaTemplate.send(message);
    }
}
