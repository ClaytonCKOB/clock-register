package org.ckob.clock_register.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

@Entity(name="user")
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
}
