package com.utn.PhoneLines.controller;


import com.utn.PhoneLines.model.Customer;
import com.utn.PhoneLines.projection.CustomerCant;
import com.utn.PhoneLines.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")

public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/")
    public List<Customer> getAll() {
        return customerService.getAll();
    }


    @PostMapping("/")
    public void addCustomer(@RequestBody final Customer customer) {
        customerService.add(customer);

    }

    @GetMapping("/projection")
    public List<CustomerCant> getCustomerCant() {
        return customerService.getCustomerCant();
    }
}
