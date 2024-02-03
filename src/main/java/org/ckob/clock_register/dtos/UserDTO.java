package org.ckob.clock_register.dtos;

import org.ckob.clock_register.domain.Role;

public record UserDTO(
        Long id,
        String name,

        String username,

        String password,

        Role role
) {
}
