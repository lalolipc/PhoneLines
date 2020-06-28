package com.utn.PhoneLines.service;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.model.UserType;
import com.utn.PhoneLines.model.dto.LoginInput;
import com.utn.PhoneLines.model.dto.UpdateUserDto;
import com.utn.PhoneLines.model.enums.UserTypeEnum;
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

    public User add(User user) {
        return this.userRepository.save(user);
    }

    public User getById(Integer idUser) throws UserNotExistsException {
        return userRepository.findById(idUser).orElseThrow(UserNotExistsException::new);
    }

    public void delete(Integer idUser) throws UserNotExistsException {
        userRepository.delete(idUser);
    }

    public User update(Integer idUser, UpdateUserDto userDto) throws ValidationException {

        User old = this.userRepository.findById(idUser).get();

        if(!userDto.getUserType().equals(UserTypeEnum.BACKOFFICE.toString())){
            if(!userDto.getUserType().equals(UserTypeEnum.CLIENT.toString())) {
                return (User) Optional.ofNullable(null).orElseThrow(() -> new ValidationException("User type is not valid"));
            }
        }
        old.setName(userDto.getName());
        old.setLastName(userDto.getLastname());
        return this.userRepository.save(old);
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
