package org.ckob.clock_register.producers;

import org.ckob.clock_register.dtos.ClockIntervalDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClockIntervalProducer {
    final RabbitTemplate rabbitTemplate;

    public ClockIntervalProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "clock_interval")
    private String routingKey;

    public void sendCreateInterval(ClockIntervalDTO clockIntervalDTO) {
        rabbitTemplate.convertAndSend("", routingKey, clockIntervalDTO);
    }
}
