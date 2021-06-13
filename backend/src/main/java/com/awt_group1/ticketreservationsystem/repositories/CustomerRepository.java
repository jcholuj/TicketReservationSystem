package com.awt_group1.ticketreservationsystem.repositories;

import com.awt_group1.ticketreservationsystem.entities.Auth;
import com.awt_group1.ticketreservationsystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByMail(String var1);

    Optional<Customer> findByMailAndEncryptedPassword(String var1, String var2);
}
