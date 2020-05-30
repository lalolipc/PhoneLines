package com.utn.PhoneLines.controller;


import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.projection.UserCant;
import com.utn.PhoneLines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }


    @PostMapping("/")
    public void addPet(@RequestBody final User user) {
        userService.add(user);

    }

    @GetMapping("/projection")
    public List<UserCant> getUserCant() {
        return userService.getUserCant();
    }
}
