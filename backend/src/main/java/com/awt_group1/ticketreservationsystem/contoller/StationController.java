package com.awt_group1.ticketreservationsystem.contoller;


import com.awt_group1.ticketreservationsystem.model.Station;
import com.awt_group1.ticketreservationsystem.model.StationDTO;
import com.awt_group1.ticketreservationsystem.services.StationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/station")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/all")
    public List<StationDTO> findAllStations() {
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
    public StationDTO getById(@PathVariable String id) { return stationService.getById(id); }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) { stationService.removeById(id); }

    @GetMapping("/origin")
    public List<StationDTO> getAllPossibleDestinationsForOrigin(@RequestParam String originId) {
        return stationService.getAllConnectionDestinationsForGivenOrigin(originId);
    }

    @GetMapping("/destination")
    public List<StationDTO> getAllPossibleOriginsForDestination(@RequestParam String destinationId) {
        return stationService.getAllConnectionOriginsForGivenDestination(destinationId);
    }
}
