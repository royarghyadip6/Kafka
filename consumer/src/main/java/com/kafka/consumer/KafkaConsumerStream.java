package com.kafka.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class KafkaConsumerStream {

    @Bean
    public Consumer<RiderLocation> riderLocationConsumer() {
        return riderLocation -> {
            System.out.println("Received RiderLocation: " + riderLocation.getRiderId() + " at (" + riderLocation.getLatitude() + ", " + riderLocation.getLongitude() + ")");
            // Additional processing can be done here
        };
    }

    @Bean
    public Consumer<String> riderStatusConsumer() {
        return riderStatus -> {
            System.out.println("Received RiderStatus: " + riderStatus);
            // Additional processing can be done here
        };
    }
}
