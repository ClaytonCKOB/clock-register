package org.ckob.clock_register.domain;

import jakarta.persistence.*;
import lombok.*;
import org.ckob.clock_register.dtos.UserDTO;
import org.hibernate.annotations.IdGeneratorType;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public User(UserDTO user){
        this.name = user.name();
    }
}
