package com.awt_group1.ticketreservationsystem.contoller;


import com.awt_group1.ticketreservationsystem.model.Train;
import com.awt_group1.ticketreservationsystem.model.TrainDTO;
import com.awt_group1.ticketreservationsystem.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/{id}")
    public TrainDTO getById(@PathVariable String id) { return trainService.getById(id); }

    @GetMapping("/all")
    public List<TrainDTO> getAll() { return trainService.getAll(); }

    @PostMapping
    public void createTrain(@RequestBody TrainDTO train) {
        trainService.add(train);
    }

    @PutMapping
    public void updateTrain(@RequestBody TrainDTO train) {
        trainService.update(train);
    }

    @DeleteMapping("/{id}")
    public void deleteTrain(@PathVariable String id) { trainService.removeById(id); }
}
