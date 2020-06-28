package com.utn.PhoneLines.service;

import com.utn.PhoneLines.model.Phone;
import com.utn.PhoneLines.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    private PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }


    public List<Phone> getAll() {

        return phoneRepository.findAll();
    }
    public Phone add(Phone phone) {
        return phoneRepository.save(phone);
    }

    public Phone getById(Integer id) {

        return this.phoneRepository.findById(id);
    }

    public Phone getByPhoneNumber(String phoneNumber) {

        return this.phoneRepository.findByNumber(phoneNumber);
    }

    public void delete(Phone phone) {

        this.phoneRepository.delete(phone);
    }

    public Phone update(Phone phoneLine) {
        return this.phoneRepository.save(phoneLine);
    }
}
