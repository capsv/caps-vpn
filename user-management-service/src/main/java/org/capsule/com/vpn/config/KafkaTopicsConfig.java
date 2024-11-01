package org.capsule.com.vpn.config;

import static org.capsule.com.vpn.config.Topics.NEW_USER_ACCOUNT_TOPIC;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicsConfig {

    private static final Integer PARTITIONS = 1;
    private static final Integer REPLICATION_FACTOR = 1;

    @Bean
    public NewTopic newUserAccountTopic() {
        return TopicBuilder.name(NEW_USER_ACCOUNT_TOPIC)
            .partitions(PARTITIONS)
            .replicas(REPLICATION_FACTOR)
            .build();
    }
}
