package com.utn.PhoneLines.controller;


import com.utn.PhoneLines.model.Customer;
import com.utn.PhoneLines.projection.CustomerCant;
import com.utn.PhoneLines.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @ResponseBody
    public List<Customer> getAll(@RequestParam(required = false)String name) {

        return customerService.getAll(name);
    }


    @PostMapping("/")
    public void addCustomer(@RequestBody final Customer customer) {
        customerService.add(customer);

    }

    @GetMapping("/projection")
    public List<CustomerCant> getCustomerCant() {
        return customerService.getCustomerCant();
    }
/*
    @GetMapping("pricelastcall/{id_customer}")
    public ResponseEntity getPriceLastCallById(@PathVariable Integer id_customer) {

        ResponseEntity response;

        try {

            response = costumerService.getPriceLastCall(id_customer);

        } catch (UserNotexistException E){

            response = new ResponseEntity("User not exist", HttpStatus.CONFLICT);
        }

        return response;
    }*/
}
