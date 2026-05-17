package com.kafka.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.function.Supplier;

@Configuration
public class KafkaProducerStream {

    @Bean
    public Supplier<RiderLocation> riderLocationSupplier() {
        Random random = new Random();
        return () -> {
            String riderId = "Rider-" + random.nextInt(100); // Example rider ID
            double latitude = 37.7749; // Example latitude
            double longitude = 122.4194; // Example longitude
            RiderLocation riderLocation = new RiderLocation(riderId, latitude + Math.random() * 0.1, longitude + Math.random() * 0.1);
            System.out.println("Generated RiderLocation: " + riderLocation.getRiderId() + " at (" + riderLocation.getLatitude() + ", " + riderLocation.getLongitude() + ")");
            return riderLocation;
        };
    }

    @Bean
    public Supplier<String> riderStatusSupplier() {
        Random random = new Random();
        return () -> {
            String riderId = "Rider-" + random.nextInt(100); // Example rider ID
            Boolean status = random.nextBoolean(); // Example status
            String statusString = status ? "Active" : "Inactive";
            System.out.println("Generated RiderStatus: " + riderId + " is " + statusString);
            return riderId + ":" + statusString;
        };
    }
}
