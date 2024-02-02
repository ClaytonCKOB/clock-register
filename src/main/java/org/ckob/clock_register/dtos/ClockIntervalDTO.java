package org.ckob.clock_register.dtos;

import java.time.LocalDateTime;

public record ClockIntervalDTO(
        Long id,
        Long id_user,
        LocalDateTime start,
        LocalDateTime ending
) {
}
