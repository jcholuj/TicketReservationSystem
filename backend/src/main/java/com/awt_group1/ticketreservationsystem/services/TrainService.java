package com.awt_group1.ticketreservationsystem.services;

import com.awt_group1.ticketreservationsystem.model.Train;
import com.awt_group1.ticketreservationsystem.model.TrainDTO;
import com.awt_group1.ticketreservationsystem.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainService {
    @Autowired
    TrainRepository trainRepository;

    public TrainService() { }

    public TrainDTO getById(String id) { return new TrainDTO(this.trainRepository.findById(id)); }

    public List<TrainDTO> getAll() { return this.trainRepository.findAll().stream().map(TrainDTO::new).collect(Collectors.toList()); }

    public void removeById(String id) { this.trainRepository.deleteById(id); }

    public void update(TrainDTO train) {
        trainRepository.save(new Train(train));
    }

    public void add(TrainDTO train) {
        trainRepository.save(new Train(train));
    }
}
