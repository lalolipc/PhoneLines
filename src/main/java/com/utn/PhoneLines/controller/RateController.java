package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.exceptions.ResourceNotExistException;
import com.utn.PhoneLines.model.Phone;
import com.utn.PhoneLines.model.Rate;
import com.utn.PhoneLines.service.PhoneService;
import com.utn.PhoneLines.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rate")
public class RateController {

        private final RateService rateService;

        @Autowired
        public RateController(RateService rateService) {
            this.rateService = rateService;
        }

        @GetMapping("/")
        public List<Rate> getAll()
        {
            return rateService.getAll();
        }


        @PostMapping("/")
        public void addRate(@RequestBody final Rate rate){
            rateService.add(rate);

        }

    public ResponseEntity<List<Rate>> getRates() {
        return rateService.getRates();
    }

    public ResponseEntity<Rate> getRatesbyCity(Integer idCityFrom, Integer idCityTo) throws ResourceNotExistException {
        return ResponseEntity.ok(this.rateService.getRatesbyCity(idCityFrom, idCityTo));
    }
}
