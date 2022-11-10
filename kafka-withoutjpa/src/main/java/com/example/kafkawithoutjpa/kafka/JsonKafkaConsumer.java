package com.example.kafkawithoutjpa.kafka;

import com.example.kafkawithoutjpa.payload.User;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class JsonKafkaConsumer {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
    @KafkaListener(topics = "springtopic_1", groupId = "group-id")
    public void consumer(User user)
    {
        LOGGER.info(String.format("Json message received -> %s", user.toString()));
    }
}
