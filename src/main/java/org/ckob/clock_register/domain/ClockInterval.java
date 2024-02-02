package org.ckob.clock_register.domain;

import jakarta.persistence.*;
import lombok.*;
import org.ckob.clock_register.dtos.ClockIntervalDTO;

import java.time.LocalDateTime;

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

    private LocalDateTime start;

    private LocalDateTime ending;

    public ClockInterval(ClockIntervalDTO clockInterval){
        this.id_user = clockInterval.id_user();
        this.start = clockInterval.start();
        this.ending = clockInterval.ending();
    }
}
