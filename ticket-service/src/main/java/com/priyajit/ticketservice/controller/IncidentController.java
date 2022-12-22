package com.priyajit.ticketservice.controller;

import com.priyajit.ticketservice.dto.IncidentRequestDTO;
import com.priyajit.ticketservice.dto.IncidentResponseDTO;
import com.priyajit.ticketservice.entity.IncidentTicket;
import com.priyajit.ticketservice.factory.IncidentResponseDTOFactory;
import com.priyajit.ticketservice.service.IncidentTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inc")
public class IncidentController {

    @Autowired
    private IncidentTicketService incidentTicketService;

    @Autowired
    private IncidentResponseDTOFactory incidentResponseDTOFactory;

    @PostMapping
    public IncidentResponseDTO create(@RequestBody IncidentRequestDTO incidentRequestDTO){
        IncidentTicket incidentTicket = incidentTicketService.create(incidentRequestDTO);
        return incidentResponseDTOFactory.fromIncidentTicket(incidentTicket);
    }

    @GetMapping("/{ticketId}")
    public IncidentResponseDTO get(@PathVariable(name="ticketId") Long ticketId){
        IncidentTicket incidentTicket = incidentTicketService.get(ticketId);
        return incidentResponseDTOFactory.fromIncidentTicket(incidentTicket);
    }

    @PatchMapping
    public IncidentResponseDTO update(@RequestBody IncidentRequestDTO incidentRequestDTO){
        IncidentTicket incidentTicket = incidentTicketService.updateSpecific(incidentRequestDTO);
        return incidentResponseDTOFactory.fromIncidentTicket(incidentTicket);
    }
}
