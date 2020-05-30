package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.service.CityService;
import com.utn.PhoneLines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @Autowired

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public List<City> getAll()
    {
        return cityService.getAll();
    }


    @PostMapping("/")
    public void addPet(@RequestBody final City city){
        cityService.add(city);

    }
}
