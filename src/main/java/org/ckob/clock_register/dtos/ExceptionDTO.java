package org.ckob.clock_register.dtos;

public record ExceptionDTO(
        String message,
        Integer statusCode
) {
}
