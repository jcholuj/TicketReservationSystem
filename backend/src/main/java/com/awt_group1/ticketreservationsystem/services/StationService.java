package com.awt_group1.ticketreservationsystem.services;

import com.awt_group1.ticketreservationsystem.model.Station;
import com.awt_group1.ticketreservationsystem.repositories.ConnectionRepository;
import com.awt_group1.ticketreservationsystem.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StationService {
    @Autowired
    StationRepository stationRepository;
    ConnectionRepository connectionRepository;

    public StationService() { }

    public List<Station> findAll() { return this.stationRepository.findAll(); }

    public Optional<Station> getById(String id) { return this.stationRepository.findById(id); }

    public void removeById(String id) { this.stationRepository.deleteById(id); }

    public void addStation(Station station) { this.stationRepository.save(station); }

    public void updateStation(Station station) { this.stationRepository.save(station); }

    public List<Station> getAllConnectionDestinationsForGivenOrigin(String originId) {
        return connectionRepository
                .findAll()
                .stream()
                .filter(c -> c.getOriginId().equals(originId))
                .map(c -> stationRepository.findById(c.getDestinationId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<Station> getAllConnectionOriginsForGivenDestination(String destinationId) {
        return connectionRepository
                .findAll()
                .stream()
                .filter(c -> c.getDestinationId().equals(destinationId))
                .map(c -> stationRepository.findById(c.getOriginId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
