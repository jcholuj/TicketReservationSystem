package com.awt_group1.ticketreservationsystem.services;

import com.awt_group1.ticketreservationsystem.entities.Connection;
import com.awt_group1.ticketreservationsystem.repositories.ConnectionRepository;
import com.awt_group1.ticketreservationsystem.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConnectionService {
    @Autowired
    ConnectionRepository connectionRepository;
    StationRepository stationRepository;

    public ConnectionService() { }

    public List<Connection> findAll() { return this.connectionRepository.findAll(); }

    public Optional<Connection> findById(String id) { return this.connectionRepository.findById(id); }

    public void deleteById(String id) { this.connectionRepository.deleteById(id); }

    public List<Connection> getAllConnectionFromTo(String fromId, String toId) {
        return this.connectionRepository
                .findAll()
                .stream()
                .filter(c -> c.getOriginId().equals(fromId) && c.getDestinationId().equals(toId))
                .collect(Collectors.toList());
    }
}
