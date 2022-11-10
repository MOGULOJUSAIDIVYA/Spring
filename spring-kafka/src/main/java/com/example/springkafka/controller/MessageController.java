package com.example.springkafka.controller;

import com.example.springkafka.kafka.KafkaProducer;
import com.example.springkafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private KafkaProducer kafkaProducer;
    public MessageController(KafkaProducer kafkaProducer)
    {
        this.kafkaProducer=kafkaProducer;
    }
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") User message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");

    }
}
