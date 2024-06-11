package org.ckob.clock_register.services;

import org.ckob.clock_register.domain.ClockInterval;
import org.ckob.clock_register.dtos.ClockIntervalDTO;
import org.ckob.clock_register.repositories.ClockIntervalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

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

    public ClockInterval setAutomaticallyClock(ClockIntervalDTO clockInterval){
        LocalDate today = LocalDate.now();
        LocalTime today_time = LocalTime.now();

        Optional<ClockInterval> clockEnding = this.clockIntervalRepository.findFirstEmptyEnding();

        if(clockEnding.isPresent()){
            ClockInterval intervalToUpdate = clockEnding.get();
            intervalToUpdate.setEnd_date(today);
            intervalToUpdate.setEnd_time(today_time);
            return this.clockIntervalRepository.save(intervalToUpdate);
        } else {
            Long id_user = clockInterval.id_user();
            ClockInterval newInterval = new ClockInterval();
            newInterval.setId_user(id_user);
            newInterval.setStart_date(today);
            newInterval.setStart_time(today_time);
            return this.clockIntervalRepository.save(newInterval);
        }
    }

    public void deleteClockInterval(Long id) {
        this.clockIntervalRepository.deleteById(id);
    }
}
