package org.ckob.clock_register.repositories;

import jakarta.persistence.EntityManager;
import org.ckob.clock_register.domain.ClockInterval;
import org.ckob.clock_register.domain.User;
import org.ckob.clock_register.dtos.ClockIntervalDTO;
import org.ckob.clock_register.dtos.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ClockIntervalRepositoryTest {
    @Autowired
    ClockIntervalRepository clockIntervalRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should find empty ending interval.")
    void findFirstEmptyEndingSucess() {
        ClockInterval newInterval = this.createClockInterval(new ClockIntervalDTO(1L, 1L, LocalDateTime.now(), null));

        Optional<ClockInterval> interval = this.clockIntervalRepository.findFirstEmptyEnding();

        assertThat(interval.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not find empty ending interval.")
    void findFirstEmptyEndingNotFound() {
        ClockInterval newInterval = this.createClockInterval(new ClockIntervalDTO(1L, 1L, LocalDateTime.now(),  LocalDateTime.now()));

        Optional<ClockInterval> interval = this.clockIntervalRepository.findFirstEmptyEnding();

        assertThat(interval.isPresent()).isFalse();
    }

    private ClockInterval createClockInterval(ClockIntervalDTO data){
        ClockInterval newInterval = new ClockInterval(data);
        this.entityManager.persist(newInterval);
        return newInterval;
    }
}