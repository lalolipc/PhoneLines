package com.utn.PhoneLines.service;

import com.utn.PhoneLines.model.Customer;
import com.utn.PhoneLines.projection.CustomerCant;
import com.utn.PhoneLines.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
@Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {

            return customerRepository.findAll();
    }

    public void add(Customer customer) {

    this.customerRepository.save(customer);
    }
    public List<CustomerCant> getCustomerCant(){
        return customerRepository.getCustomerCant();
    }

}
