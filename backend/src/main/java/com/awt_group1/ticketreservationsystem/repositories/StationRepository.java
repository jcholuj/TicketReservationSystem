package com.awt_group1.ticketreservationsystem.repositories;

import com.awt_group1.ticketreservationsystem.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, String> {
}
