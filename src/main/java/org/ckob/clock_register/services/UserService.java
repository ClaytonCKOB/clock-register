package org.ckob.clock_register.services;

import jakarta.persistence.Access;
import org.ckob.clock_register.domain.Credential;
import org.ckob.clock_register.domain.User;
import org.ckob.clock_register.dtos.UserDTO;
import org.ckob.clock_register.repositories.CredentialRepository;
import org.ckob.clock_register.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    public User createUser(UserDTO user){
        User newUser = new User(user);
        User createdUser = this.userRepository.save(newUser);
        Credential newCredential = new Credential(user, createdUser.getId());
        this.credentialRepository.save(newCredential);
        return createdUser;
    }

    public User getUser(Long id) throws Exception{
        return this.userRepository.findById(id).orElseThrow(() -> new Exception("User not found."));
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
}
