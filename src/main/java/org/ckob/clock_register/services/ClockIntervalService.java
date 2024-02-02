package org.ckob.clock_register.services;

import org.ckob.clock_register.domain.ClockInterval;
import org.ckob.clock_register.domain.User;
import org.ckob.clock_register.dtos.ClockIntervalDTO;
import org.ckob.clock_register.dtos.UserDTO;
import org.ckob.clock_register.repositories.ClockIntervalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockIntervalService {
    private ClockIntervalRepository clockIntervalRepository;

    public ClockInterval createClockInterval(ClockIntervalDTO clockInteval){
        ClockInterval newClockInterval = new ClockInterval(clockInteval);
        return this.clockIntervalRepository.save(newClockInterval);
    }

    public ClockInterval getClockInterval(Long id) throws Exception{
        return this.clockIntervalRepository.findById(id).orElseThrow(() -> new Exception("Clock interval not found."));
    }

    public List<ClockInterval> getAllClockIntervals(){
        return this.clockIntervalRepository.findAll();
    }
}
