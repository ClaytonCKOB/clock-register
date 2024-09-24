package org.ckob.clock_register.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.ckob.clock_register.domain.ClockInterval;
import org.ckob.clock_register.dtos.ClockIntervalDTO;
import org.ckob.clock_register.producers.ClockIntervalProducer;
import org.ckob.clock_register.repositories.ClockIntervalRepository;
import org.ckob.clock_register.services.ClockIntervalService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("api/clock")
public class ClockIntervalController {

    @Autowired
    private ClockIntervalProducer clockIntervalProducer;

    @Autowired
    private ClockIntervalService clockIntervalService;

    @GetMapping
    public List<ClockInterval> getAllClockIntervals(){
        return clockIntervalService.getAllClockIntervals();
    }

    @GetMapping(path="{id}")
    public ClockInterval getClockInterval(@PathVariable("id") Long id) throws Exception{
        return clockIntervalService.getClockInterval(id);
    }

    @PostMapping
    public void createClockInterval(@RequestBody ClockIntervalDTO clockInterval) throws Exception{
        clockIntervalProducer.sendCreateInterval(clockInterval);
    }

    @PostMapping
    @RequestMapping("/set-auto")
    public ClockInterval setAutomaticallyClock(@RequestBody ClockIntervalDTO clockInterval){
        return clockIntervalService.setAutomaticallyClock(clockInterval);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClockInterval(@PathVariable("id") Long idClockInterval) throws Exception {
        clockIntervalService.deleteClockInterval(idClockInterval);
    }
}
