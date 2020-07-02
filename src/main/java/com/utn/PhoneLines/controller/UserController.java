package com.utn.PhoneLines.controller;


import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.exceptions.ValidationException;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.model.dto.UpdateUserDto;
import com.utn.PhoneLines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    //ok
    public ResponseEntity<User> getUserById(Integer idUser) throws UserNotExistsException {
        return ResponseEntity.ok(userService.getById(idUser));
    }

    //ok
    public void delete(Integer idUser) throws UserNotExistsException {
        userService.delete(idUser);
    }
    //ok
    public ResponseEntity<User> update(Integer idUser, UpdateUserDto user) throws ValidationException, UserNotExistsException {
        return ResponseEntity.ok(this.userService.update( idUser , user));
    }

    public List<User> getAll(@RequestParam(required = false)String name) {
        return userService.getAll(name);
    }

    public ResponseEntity addUser(@RequestBody final User user) {
        return ResponseEntity.created(getLocation(this.userService.add(user))).build();
    }

    //ok powerMock
    private URI getLocation(User user) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}/")
                .buildAndExpand(user.getIdUser())
                .toUri();
    }

}
