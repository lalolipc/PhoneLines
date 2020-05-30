package com.utn.PhoneLines.service;

import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.projection.UserCant;
import com.utn.PhoneLines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void add(User user) {
    userRepository.save(user);
    }
    public List<UserCant> getUserCant(){
        return userRepository.getUserCant();
    }

}
