package com.utn.PhoneLines.service;

import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.repository.CityRepository;
import com.utn.PhoneLines.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    public List<Invoice> getAll() {

        return invoiceRepository.findAll();
    }
    public void add(Invoice invoice) {
        invoiceRepository.save(invoice);
    }
}
