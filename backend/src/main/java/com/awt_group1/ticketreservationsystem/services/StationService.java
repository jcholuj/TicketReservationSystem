package com.awt_group1.ticketreservationsystem.services;

import com.awt_group1.ticketreservationsystem.model.Station;
import com.awt_group1.ticketreservationsystem.model.StationDTO;
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

    public List<StationDTO> findAll() { return this.stationRepository.findAll().stream().map(StationDTO::new).collect(Collectors.toList()); }

    public StationDTO getById(String id) { return new StationDTO(this.stationRepository.findById(id)); }

    public void removeById(String id) { this.stationRepository.deleteById(id); }

    public void addStation(Station station) { this.stationRepository.save(station); }

    public void updateStation(Station station) { this.stationRepository.save(station); }

    public List<StationDTO> getAllConnectionDestinationsForGivenOrigin(String originId) {
        return connectionRepository
                .findAll()
                .stream()
                .filter(c -> c.getStationByOriginId().getStationId().equals(originId))
                .map(c -> stationRepository.findById(c.getStationByDestinationId().getStationId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(StationDTO::new)
                .collect(Collectors.toList());
    }

    public List<StationDTO> getAllConnectionOriginsForGivenDestination(String destinationId) {
        return connectionRepository
                .findAll()
                .stream()
                .filter(c -> c.getStationByDestinationId().getStationId().equals(destinationId))
                .map(c -> stationRepository.findById(c.getStationByOriginId().getStationId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(StationDTO::new)
                .collect(Collectors.toList());
    }
}
