package com.awt_group1.ticketreservationsystem.services;

import com.awt_group1.ticketreservationsystem.entities.StationLink;
import com.awt_group1.ticketreservationsystem.entities.Train;
import com.awt_group1.ticketreservationsystem.repositories.StationLinkRepository;
import com.awt_group1.ticketreservationsystem.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TrainService {
    @Autowired
    TrainRepository trainRepository;

    public TrainService() { }

    public Optional<Train> getById(String id) { return this.trainRepository.findById(id); }

    public List<Train> getAll() { return this.trainRepository.findAll(); }

    public void removeById(String id) { this.trainRepository.deleteById(id); }

    public void update(Train train) {
        trainRepository.save(train);
    }

    public void add(Train train) {
        trainRepository.save(train);
    }
}
