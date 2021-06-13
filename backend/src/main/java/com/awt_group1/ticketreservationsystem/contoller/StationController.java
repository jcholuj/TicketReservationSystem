package com.awt_group1.ticketreservationsystem.contoller;

import com.awt_group1.ticketreservationsystem.entities.Station;
import com.awt_group1.ticketreservationsystem.entities.StationLink;
import com.awt_group1.ticketreservationsystem.repositories.StationRepository;
import com.awt_group1.ticketreservationsystem.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/all")
    public List<Station> findAllStations() {
        return stationService.findAll();
    }

    @PostMapping
    public void addStation(@RequestBody Station station) {
        stationService.addStation(station);
    }

    @PutMapping
    public void updateStation(@RequestBody Station station) {
        stationService.updateStation(station);
    }

    @GetMapping("/{id}")
    public Optional<Station> getById(@PathVariable String id) { return stationService.getById(id); }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) { stationService.removeById(id); }

    @GetMapping("/origin")
    public List<Station> getAllPossibleDestinationsForOrigin(@RequestParam String originId) {
        return stationService.getAllConnectionDestinationsForGivenOrigin(originId);
    }

    @GetMapping("/destination")
    public List<Station> getAllPossibleOriginsForDestination(@RequestParam String destinationId) {
        return stationService.getAllConnectionOriginsForGivenDestination(destinationId);
    }
}
