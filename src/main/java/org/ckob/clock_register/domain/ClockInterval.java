package org.ckob.clock_register.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.ckob.clock_register.dtos.ClockIntervalDTO;

import java.time.LocalDateTime;

@Entity(name="clock_interval")
@Table(name="clock_interval")
@AllArgsConstructor
@NoArgsConstructor
public class ClockInterval {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private LocalDateTime start;

    private LocalDateTime end;

    public ClockInterval(ClockIntervalDTO clockInterval){
        this.start = clockInterval.start();
        this.end = clockInterval.end();
    }
}
