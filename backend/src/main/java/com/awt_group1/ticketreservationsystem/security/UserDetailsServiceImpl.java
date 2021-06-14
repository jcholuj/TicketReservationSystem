package com.awt_group1.ticketreservationsystem.security;

import com.awt_group1.ticketreservationsystem.entity.Role;
import com.awt_group1.ticketreservationsystem.model.CustomerData;
import com.awt_group1.ticketreservationsystem.repositories.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {
    private CustomerRepository customerRepository;
    public UserDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        Optional<CustomerData> customer = null;
        if (customer.isEmpty()) {
            throw new UsernameNotFoundException("User is not Found");
        }
        return new org.springframework.security.core.userdetails.User(customer.get().getUsername(),
                customer.get().getCustomerPassword(),
                mapRolesToAuthorities(new ArrayList<>()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().toString()))
                .collect(Collectors.toList());
    }
}