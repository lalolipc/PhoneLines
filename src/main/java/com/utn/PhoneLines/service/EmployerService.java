package com.utn.PhoneLines.service;

import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.Employer;
import com.utn.PhoneLines.repository.CityRepository;
import com.utn.PhoneLines.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }


    public List<Employer> getAll() {

        return employerRepository.findAll();
    }
    public void add(Employer employer) {
        employerRepository.save(employer);
    }

}
