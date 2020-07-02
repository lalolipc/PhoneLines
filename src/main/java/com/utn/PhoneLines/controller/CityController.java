package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @Autowired

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }



}
