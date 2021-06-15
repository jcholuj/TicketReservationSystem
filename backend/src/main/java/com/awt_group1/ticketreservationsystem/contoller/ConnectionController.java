package com.awt_group1.ticketreservationsystem.contoller;


import com.awt_group1.ticketreservationsystem.model.Connection;
import com.awt_group1.ticketreservationsystem.model.ConnectionDTO;
import com.awt_group1.ticketreservationsystem.services.ConnectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/connection")
public class ConnectionController {

    private final ConnectionService connectionService;

    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @GetMapping("/{id}")
    public ConnectionDTO getConnectionById(@PathVariable String id) { return connectionService.findById(id); }

    @DeleteMapping("/{id}")
    public void removeConnectionById(@PathVariable String id) { connectionService.deleteById(id); }

    @GetMapping("/all")
    public List<ConnectionDTO> getAllConnections() { return connectionService.findAll(); }

    @GetMapping("/between")
    public List<ConnectionDTO> getAllConnectionsBetween(
            @RequestParam String originId,
            @RequestParam String destinationId) {
        return connectionService.getAllConnectionFromTo(originId, destinationId);
    }
}

//http://localhost:8080/api/connection/between?originId=7e2958fd-cd6a-11eb-9292-06fa80fd6ae2&destinationId=7e295c99-cd6a-11eb-9292-06fa80fd6ae2
//
//        7e295397-cd6a-11eb-9292-06fa80fd6ae2