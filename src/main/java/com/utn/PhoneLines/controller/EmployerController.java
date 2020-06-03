package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.Employer;
import com.utn.PhoneLines.service.CityService;
import com.utn.PhoneLines.service.CustomerService;
import com.utn.PhoneLines.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/")
    public List<Employer> getAll()
    {
        return employerService.getAll();
    }


    @PostMapping("/")
    public void addEmployer(@RequestBody final Employer employer){
        employerService.add(employer);

    }
}
