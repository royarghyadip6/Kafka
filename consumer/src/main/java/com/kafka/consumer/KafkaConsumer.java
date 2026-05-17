package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void consumeMessage(String message) {
        // Logic to process the consumed message
        System.out.println("Consumed message: " + message);
    }

    /**
     * This method demonstrates consuming messages from the same topic and same group ID.
     * In this case, if there are multiple consumers with the same group ID, they will share the messages, and each message will be consumed by only one consumer in the group.
     */
    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void consumeMessageSameGroup(String message) {
        // Logic to process the consumed message
        System.out.println("Consumed message: " + message);
    }

    /**
     * This method will consume messages from the same topic but with a different group ID.
     * It will receive all messages sent to the topic, regardless of the group ID used by other consumers.
     */
    @KafkaListener(topics = "my-topic", groupId = "my-other-group")
    public void consumeMessageDifferentGroup(String message) {
        // Logic to process the consumed message
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "my-topic-A", groupId = "my-other-group")
    public void riderLocation(RiderLocation message) {
        // Logic to process the consumed message
        System.out.println("Rider id: " + message.getRiderId() + " at (" + message.getLatitude() + ", " + message.getLongitude() + ")");
    }
}
