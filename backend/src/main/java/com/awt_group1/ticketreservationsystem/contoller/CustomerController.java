package com.awt_group1.ticketreservationsystem.contoller;

import com.awt_group1.ticketreservationsystem.model.Customer;
import com.awt_group1.ticketreservationsystem.model.CustomerDTO;
import com.awt_group1.ticketreservationsystem.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") String id) {
        return customerService.getById(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerDTO customer) {
        customerService.add(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@RequestBody CustomerDTO customer) {
        customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") String id) {
        customerService.removeById(id);
    }
}
