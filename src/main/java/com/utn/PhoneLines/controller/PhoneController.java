package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.Phone;
import com.utn.PhoneLines.service.CityService;
import com.utn.PhoneLines.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    private final PhoneService phoneService;

    @Autowired

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/")
    public List<Phone> getAll()
    {
        return phoneService.getAll();
    }


    @PostMapping("/")
    public void addPhone(@RequestBody final Phone phone){
        phoneService.add(phone);

    }
}
