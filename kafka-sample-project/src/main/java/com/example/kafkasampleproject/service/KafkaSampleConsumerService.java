package com.example.kafkasampleproject.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaSampleConsumerService {
    @KafkaListener(topics = "oingdaddy", groupId = "group-id-oing")
    public void consume(String message) throws IOException{
        System.out.println("receive message : " + message);
    }
}
