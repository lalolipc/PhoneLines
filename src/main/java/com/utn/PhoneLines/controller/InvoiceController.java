package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.model.Invoice;
import com.utn.PhoneLines.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;
    @Autowired

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/")
    public List<Invoice> getAll()
    {
        return invoiceService.getAll();
    }


    @PostMapping("/")
    public void addInvoice(@RequestBody final Invoice invoice){
        invoiceService.add(invoice);

    }
}
