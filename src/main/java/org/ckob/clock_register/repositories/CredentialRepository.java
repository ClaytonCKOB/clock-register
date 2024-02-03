package org.ckob.clock_register.repositories;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository {
    UserDetails findByUsername(String username);
}
