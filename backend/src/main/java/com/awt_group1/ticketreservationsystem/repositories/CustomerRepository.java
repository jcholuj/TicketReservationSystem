package com.awt_group1.ticketreservationsystem.repositories;

import com.awt_group1.ticketreservationsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
//    Optional<CustomerData> findByMail(String var1);
//
//    Optional<CustomerData> findByMailAndEncryptedPassword(String var1, String var2);
}
