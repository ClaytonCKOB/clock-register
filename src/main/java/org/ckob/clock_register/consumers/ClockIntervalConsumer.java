package org.ckob.clock_register.consumers;

import org.ckob.clock_register.dtos.ClockIntervalDTO;
import org.ckob.clock_register.services.ClockIntervalService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClockIntervalConsumer {

    @Autowired
    ClockIntervalService clockIntervalService;

    @RabbitListener(queues = "clock_interval")
    public void listen (ClockIntervalDTO clockIntervalDTO) {
        System.out.println("Begin process");
        clockIntervalService.createClockInterval(clockIntervalDTO);
        System.out.println("End process");
    }
}
