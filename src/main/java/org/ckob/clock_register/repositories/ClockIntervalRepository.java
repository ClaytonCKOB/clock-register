package org.ckob.clock_register.repositories;

import org.ckob.clock_register.domain.ClockInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockIntervalRepository extends JpaRepository<ClockInterval, Long> {
}
