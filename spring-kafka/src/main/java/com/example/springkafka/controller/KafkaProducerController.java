package com.example.springkafka.controller;
import com.example.springkafka.kafka.KafkaProducer;
import com.example.springkafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {
    private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
