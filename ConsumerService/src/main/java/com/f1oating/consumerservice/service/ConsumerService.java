package com.f1oating.consumerservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Message received: " + message);
    }
}
