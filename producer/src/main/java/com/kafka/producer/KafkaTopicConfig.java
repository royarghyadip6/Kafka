package com.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    /**
     * This configuration class is responsible for creating a Kafka topic named "my-topic-A" with 3 partitions and a replication factor of 2.
     * The KafkaAdmin bean is required to manage Kafka topics and other administrative tasks.
     */
/*    @Bean
    public NewTopic createTopic() {
        return new NewTopic("my-topic-A", 3, (short) 2);
    }*/
}
