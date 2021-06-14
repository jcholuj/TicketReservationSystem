package com.awt_group1.ticketreservationsystem.services;

import com.awt_group1.ticketreservationsystem.entity.Auth;
import com.awt_group1.ticketreservationsystem.repositories.AuthRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private AuthRepository authRepository;

    @Autowired
    public AuthService(AuthRepository authRepository) { this.authRepository = authRepository; }

    @Bean
    private PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    public boolean canBeAuthenticated(String name, String password) {
        Optional<Auth> authOptional = this.authRepository.findByMail(name);
        if (authOptional.isEmpty()) {
            return false;
        } else {
            boolean matches = this.passwordEncoder().matches(password, authOptional.get().getEncryptedPassword());
            logger.info("Can be authenticated: " + matches + ", name: " + name + ", password: " + password);
            return matches;
        }
    }

    public String encodePassword(String password) { return this.passwordEncoder().encode(password); }
}
