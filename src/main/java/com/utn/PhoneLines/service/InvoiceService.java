package com.utn.PhoneLines.service;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.model.dto.RangeDate;
import com.utn.PhoneLines.projection.InvoiceUserAndDate;
import com.utn.PhoneLines.repository.InvoiceRepository;
import com.utn.PhoneLines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, UserRepository userRepository) {
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
    }


  /*  public void add(Invoice invoice) {
        invoiceRepository.save(invoice);
    }*/

    public ResponseEntity<List<InvoiceUserAndDate>> getInvoicesByUserByDate(RangeDate rangeDate) throws UserNotExistsException {
        if(this.userRepository.getById(rangeDate.getIdUser())==null){
            throw new UserNotExistsException();
        }
        List<InvoiceUserAndDate> bills = invoiceRepository.getReportInvoicesByUserByDate(rangeDate.getIdUser(), rangeDate.getDateFrom(), rangeDate.getDateTo());

        if (!bills.isEmpty()) {
            return ResponseEntity.ok(bills);

        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
    }

}
