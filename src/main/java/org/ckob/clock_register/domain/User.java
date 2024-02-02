package org.ckob.clock_register.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ckob.clock_register.dtos.UserDTO;
import org.hibernate.annotations.IdGeneratorType;

@Entity(name="user")
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    public User(UserDTO user){
        this.name = user.name();
    }
}
