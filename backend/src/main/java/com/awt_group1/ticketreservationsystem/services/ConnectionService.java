package com.awt_group1.ticketreservationsystem.services;

import com.awt_group1.ticketreservationsystem.model.Connection;
import com.awt_group1.ticketreservationsystem.model.ConnectionDTO;
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

    public ConnectionService() {
    }

    public List<ConnectionDTO> findAll() {
        return this.connectionRepository.findAll().stream().map(ConnectionDTO::new).collect(Collectors.toList());
    }

    public ConnectionDTO findById(String id) {
        return new ConnectionDTO(this.connectionRepository.findById(id));
    }

    public void deleteById(String id) {
        this.connectionRepository.deleteById(id);
    }

    public List<ConnectionDTO> getAllConnectionFromTo(String fromId, String toId) {
        return this.connectionRepository
                .findAll()
                .stream()
                .filter(c -> c.getStationByOriginId().getStationId().equals(fromId)
                                && c.getStationByDestinationId().getStationId().equals(toId))
                .map(ConnectionDTO::new)
                .collect(Collectors.toList());
    }
}
