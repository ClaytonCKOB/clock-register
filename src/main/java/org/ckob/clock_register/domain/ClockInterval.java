package org.ckob.clock_register.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name="clock_interval")
@Table(name="clock_interval")
public class ClockInterval {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private LocalDateTime start;

    private LocalDateTime end;

}
