package com.example.kafkawithoutjpa.config;
import lombok.Value;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaguidesTopic(){
        return TopicBuilder.name("springtopic")
                .build();
    }

    @Bean
    public NewTopic javaguidesJsonTopic(){
        return TopicBuilder.name("springtopic_1")
                .build();
    }
}

