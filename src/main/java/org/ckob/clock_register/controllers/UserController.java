package org.ckob.clock_register.controllers;

import org.ckob.clock_register.domain.User;
import org.ckob.clock_register.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    public User createUser(){
        return userService.createUser();
    }
}
