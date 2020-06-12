package com.utn.PhoneLines.service;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.model.dto.LoginInput;
import com.utn.PhoneLines.projection.UserCant;
import com.utn.PhoneLines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class UserService {
    private final UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(String name) {
    if(isNull(name))
    {
        return userRepository.findAll();
    }
    return  userRepository.findByName();
    }

    public void add(User user) {

    this.userRepository.save(user);
    }
    public User getById(Integer idUser) throws UserNotExistsException {

        return userRepository.findById(idUser).orElseThrow(UserNotExistsException::new);

    }

    public List<UserCant> getCustomerCant(){
        return userRepository.getUserCant();
    }

    public User getByUserNameAndPassword(LoginInput loginInput) throws UserNotExistsException, ValidationException {
        if ((loginInput.getUserName() != null) && (loginInput.getPassword() != null)) {
            User user= userRepository.getByUserNameAndPassword(loginInput.getUserName(), loginInput.getPassword());
            return Optional.ofNullable(user).orElseThrow(() -> new UserNotExistsException());
        } else {
            throw new ValidationException("username and password must have a value");
        }
    }

}
