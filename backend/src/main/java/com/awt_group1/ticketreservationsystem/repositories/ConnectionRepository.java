package com.awt_group1.ticketreservationsystem.repositories;


import com.awt_group1.ticketreservationsystem.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRepository extends JpaRepository<Connection, String> {
}
