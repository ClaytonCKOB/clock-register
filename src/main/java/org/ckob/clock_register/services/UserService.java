package org.ckob.clock_register.services;

import jakarta.persistence.Access;
import org.ckob.clock_register.domain.User;
import org.ckob.clock_register.dtos.UserDTO;
import org.ckob.clock_register.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO user){
        User newUser = new User(user);

        return this.userRepository.create(user);
    }
}
