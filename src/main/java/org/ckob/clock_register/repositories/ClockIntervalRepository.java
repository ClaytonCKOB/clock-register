package org.ckob.clock_register.repositories;

import org.ckob.clock_register.domain.ClockInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClockIntervalRepository extends JpaRepository<ClockInterval, Long> {

    @Query("SELECT c FROM clock_interval c WHERE c.ending IS NULL")
    Optional<ClockInterval> findFirstEmptyEnding();
}
