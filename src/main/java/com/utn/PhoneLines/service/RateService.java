package com.utn.PhoneLines.service;

import com.utn.PhoneLines.model.Phone;
import com.utn.PhoneLines.model.Rate;
import com.utn.PhoneLines.repository.PhoneRepository;
import com.utn.PhoneLines.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {
    private final RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }


    public List<Rate> getAll() {

        return rateRepository.findAll();
    }
    public void add(Rate rate) {
        rateRepository.save(rate);
    }
}
