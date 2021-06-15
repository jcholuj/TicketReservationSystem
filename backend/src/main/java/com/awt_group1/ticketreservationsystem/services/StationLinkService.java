package com.awt_group1.ticketreservationsystem.services;

import com.awt_group1.ticketreservationsystem.model.StationLink;
import com.awt_group1.ticketreservationsystem.model.StationLinkDTO;
import com.awt_group1.ticketreservationsystem.repositories.StationLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationLinkService {
    @Autowired
    StationLinkRepository stationLinkRepository;

    public StationLinkService() { }

    public StationLinkDTO getById(String id) { return new StationLinkDTO(this.stationLinkRepository.findById(id)); }

    public List<StationLinkDTO> getAll() { return this.stationLinkRepository.findAll().stream().map(StationLinkDTO::new).collect(Collectors.toList()); }

    public void removeById(String id) { this.stationLinkRepository.deleteById(id); }

    public void update(StationLinkDTO stationLink) {
        stationLinkRepository.save(new StationLink(stationLink));
    }

    public void add(StationLinkDTO stationLink) {
        stationLinkRepository.save(new StationLink(stationLink));
    }
}
