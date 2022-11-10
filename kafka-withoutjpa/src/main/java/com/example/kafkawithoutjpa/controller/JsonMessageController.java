package com.example.kafkawithoutjpa.controller;

import com.example.kafkawithoutjpa.kafka.JsonKafkaProducer;
import com.example.kafkawithoutjpa.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user)
    {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
