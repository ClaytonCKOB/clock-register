package org.ckob.clock_register.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue clockIntervalQueue() {
        return new Queue("clock_interval", true);
    }
}
