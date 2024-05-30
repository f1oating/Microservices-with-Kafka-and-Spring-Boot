package com.f1oating.producerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "test_topic";

    @GetMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message published successfully";
    }
}
