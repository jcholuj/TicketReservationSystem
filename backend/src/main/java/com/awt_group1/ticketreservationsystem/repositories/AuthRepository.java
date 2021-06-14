package com.awt_group1.ticketreservationsystem.repositories;

import com.awt_group1.ticketreservationsystem.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findByMail(String var1);

    Optional<Auth> findByMailAndEncryptedPassword(String var1, String var2);
}
