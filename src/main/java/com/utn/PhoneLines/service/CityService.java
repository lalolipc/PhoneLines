package com.utn.PhoneLines.service;

import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.repository.CityRepository;
import com.utn.PhoneLines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    public List<City> getAll() {

        return cityRepository.findAll();
    }
    public void add(City city) {
        cityRepository.save(city);
    }
}
