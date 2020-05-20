package com.utn.PhoneLines.service;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class UserService {
    private final UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAll() {

            return userRepository.findAll();


    }

}
