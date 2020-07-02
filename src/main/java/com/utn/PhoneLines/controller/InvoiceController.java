package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.model.User;
import com.utn.PhoneLines.model.dto.RangeDate;
import com.utn.PhoneLines.projection.CallsClient;
import com.utn.PhoneLines.projection.InvoiceUserAndDate;
import com.utn.PhoneLines.service.InvoiceService;
import com.utn.PhoneLines.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;
    private final SessionManager sessionManager;

    @Autowired
    public InvoiceController(InvoiceService invoiceService, SessionManager sessionManager) {
        this.invoiceService = invoiceService;
        this.sessionManager = sessionManager;
    }


  /*
    @GetMapping("/")
    public List<Invoice> getAll()
    {
        return invoiceService.getAll();
    }


    @PostMapping("/")
    public void addInvoice(@RequestBody final Invoice invoice){
        invoiceService.add(invoice);

    }*/

    public ResponseEntity<List<InvoiceUserAndDate>> getInvoicesBtwDates(RangeDate rangeDate) throws UserNotExistsException {

        return invoiceService.getInvoicesByUserByDate(rangeDate);
        //return listInvoices.size()>0 ? ResponseEntity.ok(listInvoices) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


/*borrar:
    public ResponseEntity<List<Invoice>> findAll(@RequestHeader("Authorization") String token)throws UserNotExistsException{

         List<Invoice> listInvoices = invoiceService.findAll();
        return listInvoices.size()>0 ? ResponseEntity.ok(listInvoices) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }*/
}
