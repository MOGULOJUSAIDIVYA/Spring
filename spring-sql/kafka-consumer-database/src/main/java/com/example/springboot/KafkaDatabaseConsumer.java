package com.example.springboot;

import com.example.springboot.entity.Data;
import com.example.springboot.repository.DataRepository;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private DataRepository dataRepository;

    public KafkaDatabaseConsumer(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "recent",groupId = "myGroup")

    public void consume(String eventMessage){

        LOGGER.info(String.format("Event message Received -> %s", eventMessage));

        Data data=new Data();
        data.setWikiEventData(eventMessage);
        dataRepository.save(data);

    }


}
