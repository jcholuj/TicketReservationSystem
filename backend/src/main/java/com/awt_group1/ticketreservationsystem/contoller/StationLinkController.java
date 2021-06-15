package com.awt_group1.ticketreservationsystem.contoller;


import com.awt_group1.ticketreservationsystem.model.StationLink;
import com.awt_group1.ticketreservationsystem.model.StationLinkDTO;
import com.awt_group1.ticketreservationsystem.services.StationLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/station/link")
public class StationLinkController {

    @Autowired
    private StationLinkService stationLinkService;

    @GetMapping("/{id}")
    public StationLinkDTO getById(@PathVariable String id) { return stationLinkService.getById(id); }

    @GetMapping("/all")
    public List<StationLinkDTO> getAll() { return stationLinkService.getAll(); }

    @PostMapping
    public void createStationLink(@RequestBody StationLinkDTO stationLink) {
        stationLinkService.add(stationLink);
    }

    @PutMapping
    public void updateStationLink(@RequestBody StationLinkDTO stationLink) {
        stationLinkService.update(stationLink);
    }

    @DeleteMapping("/{id}")
    public void deleteStationLink(@PathVariable String id) { stationLinkService.removeById(id); }
}
