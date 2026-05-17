package com.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {

    KafkaTemplate<String, RiderLocation> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        // Logic to send the message to Kafka topic
        // For example, using KafkaTemplate from Spring Kafka

        double latitude = 37.7749; // Example latitude
        double longitude = 222.4194; // Example longitude
        RiderLocation riderLocation = new RiderLocation("rider123", latitude, longitude);
        kafkaTemplate.send("my-topic-A", riderLocation);
        System.out.println("Message sent to Kafka: " + riderLocation.getRiderId() + " at (" + riderLocation.getLatitude() + ", " + riderLocation.getLongitude() + ")" );
        return "Message sent to Kafka: " + riderLocation.getRiderId() + " at (" + riderLocation.getLatitude() + ", " + riderLocation.getLongitude() + ")";
    }

}
