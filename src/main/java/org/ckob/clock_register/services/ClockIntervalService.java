package org.ckob.clock_register.services;

import org.ckob.clock_register.domain.ClockInterval;
import org.ckob.clock_register.dtos.ClockIntervalDTO;
import org.ckob.clock_register.repositories.ClockIntervalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockIntervalService {
    @Autowired
    private ClockIntervalRepository clockIntervalRepository;

    public ClockInterval createClockInterval(ClockIntervalDTO clockInterval){
        ClockInterval newClockInterval = new ClockInterval(clockInterval);
        return this.clockIntervalRepository.save(newClockInterval);
    }

    public ClockInterval getClockInterval(Long id) throws Exception{
        return this.clockIntervalRepository.findById(id).orElseThrow(() -> new Exception("Clock interval not found."));
    }

    public List<ClockInterval> getAllClockIntervals(){
        return this.clockIntervalRepository.findAll();
    }
}
