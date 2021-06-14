package com.awt_group1.ticketreservationsystem.services;

import com.awt_group1.ticketreservationsystem.entities.Customer;
import com.awt_group1.ticketreservationsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerService() { }

    public Optional<Customer> getById(String id) { return this.customerRepository.findById(id); }

    public void removeById(String id) { this.customerRepository.deleteById(id); }

    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    public void add(Customer customer) {
        customerRepository.save(customer);
    }
}
