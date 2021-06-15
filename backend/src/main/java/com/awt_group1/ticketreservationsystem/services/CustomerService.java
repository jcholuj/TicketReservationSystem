package com.awt_group1.ticketreservationsystem.services;

import com.awt_group1.ticketreservationsystem.model.Customer;
import com.awt_group1.ticketreservationsystem.model.CustomerDTO;
import com.awt_group1.ticketreservationsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerService() { }

    public CustomerDTO getById(String id) { return new CustomerDTO(this.customerRepository.findById(id)); }

    public void removeById(String id) { this.customerRepository.deleteById(id); }

    public void update(CustomerDTO customer) {
        customerRepository.save(new Customer(customer));
    }

    public void add(CustomerDTO customer) {
        customerRepository.save(new Customer(customer));
    }
}
