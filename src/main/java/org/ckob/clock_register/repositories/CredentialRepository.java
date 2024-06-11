package org.ckob.clock_register.repositories;

import org.ckob.clock_register.domain.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {
    UserDetails findByUsername(String username);
}
