package com.utn.PhoneLines.service;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.model.dto.RangeDate;
import com.utn.PhoneLines.projection.InvoiceUserAndDate;
import com.utn.PhoneLines.repository.InvoiceRepository;
import com.utn.PhoneLines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    UserRepository userRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    public void add(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public List<InvoiceUserAndDate> getInvoicesByUserByDate(RangeDate rangeDate) throws UserNotExistsException{
        return invoiceRepository.getReportInvoicesByUserByDate(rangeDate.getIdUser(), rangeDate.getDateFrom(), rangeDate.getDateTo());
    }


}
