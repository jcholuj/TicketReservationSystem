package com.awt_group1.ticketreservationsystem.contoller;

import com.awt_group1.ticketreservationsystem.entities.Customer;
import com.awt_group1.ticketreservationsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public ModelAndView home(Principal principal) {
        return (new ModelAndView("home")).addObject("principal", principal);
    }
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Optional<Customer> getCustomer(@PathVariable("id") String id) {
        return customerService.getById(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        customerService.add(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") String id) {
        customerService.removeById(id);
    }
}
