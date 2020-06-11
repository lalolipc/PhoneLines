package com.utn.PhoneLines.service;

import com.utn.PhoneLines.exceptions.UserNotExistsException;
import com.utn.PhoneLines.model.Customer;
import com.utn.PhoneLines.projection.CustomerCant;
import com.utn.PhoneLines.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
@Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll(String name) {
    if(isNull(name))
    {
        return customerRepository.findAll();
    }
    return  customerRepository.findByName();
    }

    public void add(Customer customer) {

    this.customerRepository.save(customer);
    }
    public Customer getById(Integer idCustomer) throws UserNotExistsException {

        return customerRepository.findById(idCustomer).orElseThrow(UserNotExistsException::new);

    }

    public List<CustomerCant> getCustomerCant(){
        return customerRepository.getCustomerCant();
    }

}
