package org.ckob.clock_register.config.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue clockIntervalQueue() {
        return new Queue("clock_interval", true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter () {
        return new Jackson2JsonMessageConverter();
    }
}
