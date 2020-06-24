package com.utn.PhoneLines.controller;


import com.utn.PhoneLines.exceptions.UserNotExistsException;
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
//si
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    @ResponseBody
    public List<User> getAll(@RequestParam(required = false)String name) {

        return userService.getAll(name);
    }


    @PostMapping("/backoffice/adduser")
    public void addUser(@RequestBody final User user) {
        userService.add(user);

    }

    @GetMapping("/projection")
    public List<UserCant> getCustomerCant() {
        return userService.getCustomerCant();
    }



    @GetMapping("/{idUser}")
    public User getUserById(@PathVariable Integer idUser) throws UserNotExistsException {
          return userService.getById(idUser);

    }


}
