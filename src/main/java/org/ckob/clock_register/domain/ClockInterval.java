package org.ckob.clock_register.domain;

import jakarta.persistence.*;
import lombok.*;
import org.ckob.clock_register.dtos.ClockIntervalDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name="clock_interval")
@Table(name="clock_interval")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class ClockInterval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_user;

    private LocalDate start_date;

    private LocalTime start_time;

    private LocalDate end_date;

    private LocalTime end_time;

    public ClockInterval(ClockIntervalDTO clockInterval){
        this.id_user = clockInterval.id_user();
        this.start_date = clockInterval.start_date();
        this.start_time = clockInterval.start_time();
        this.end_date = clockInterval.end_date();
        this.end_time = clockInterval.end_time();
    }
}
