package org.ckob.clock_register.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ClockIntervalDTO(
        Long id,
        Long id_user,
        LocalDate start_date,
        LocalTime start_time,
        LocalDate end_date,
        LocalTime end_time
) {
}
