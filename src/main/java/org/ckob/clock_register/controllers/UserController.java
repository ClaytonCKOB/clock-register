package org.ckob.clock_register.controllers;

import org.ckob.clock_register.domain.User;
import org.ckob.clock_register.dtos.UserDTO;
import org.ckob.clock_register.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User createUser(@RequestBody UserDTO user){
        return this.userService.createUser(user);
    }

    @GetMapping(path = "{id}")
    public User getUser(@PathVariable("id") Long id) throws Exception{
        return this.userService.getUser(id);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }
}
