package org.ckob.clock_register.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumerComponent {

    @RabbitListener(queues = "clock_interval")
    public void receive(@Payload String fileBody) {
        System.out.println("Message " + fileBody);
    }
}
