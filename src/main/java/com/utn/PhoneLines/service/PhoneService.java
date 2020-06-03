package com.utn.PhoneLines.service;

import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.model.Phone;
import com.utn.PhoneLines.repository.InvoiceRepository;
import com.utn.PhoneLines.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }


    public List<Phone> getAll() {

        return phoneRepository.findAll();
    }
    public void add(Phone phone) {
        phoneRepository.save(phone);
    }
}
