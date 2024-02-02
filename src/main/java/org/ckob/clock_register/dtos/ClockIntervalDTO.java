package org.ckob.clock_register.dtos;

import java.time.LocalDateTime;

public record ClockIntervalDTO(
        Long id,
        LocalDateTime start,
        LocalDateTime end
) {
}
