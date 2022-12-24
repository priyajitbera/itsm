package com.priyajit.ticketservice.controller;

import com.priyajit.ticketservice.dto.IncidentRequestDTO;
import com.priyajit.ticketservice.dto.IncidentResponseDTO;
import com.priyajit.ticketservice.entity.IncidentTicket;
import com.priyajit.ticketservice.exception.IncidentTicketNotFoundException;
import com.priyajit.ticketservice.factory.IncidentResponseDTOFactory;
import com.priyajit.ticketservice.service.IncidentTicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inc")
@Slf4j
public class IncidentTicketController {

    @Autowired
    private IncidentTicketService incidentTicketService;

    @Autowired
    private IncidentResponseDTOFactory incidentResponseDTOFactory;

    @PostMapping
    public IncidentResponseDTO create(@RequestBody IncidentRequestDTO incidentRequestDTO) {
        IncidentTicket incidentTicket = incidentTicketService.createIncidentTicket(incidentRequestDTO);
        return incidentResponseDTOFactory.fromIncidentTicket(incidentTicket);
    }

    @GetMapping("/{ticketId}")
    public IncidentResponseDTO get(@PathVariable(name = "ticketId") Long ticketId) {
        IncidentTicket incidentTicket = incidentTicketService.getIncidentTicket(ticketId);
        if (incidentTicket == null) {
            log.error("No IncidentTicket found with ticketId:{}", ticketId);
            throw new IncidentTicketNotFoundException(ticketId);
        }

        return incidentResponseDTOFactory.fromIncidentTicket(incidentTicket);
    }

    @PatchMapping("/{ticketId}")
    public IncidentResponseDTO patch(
            @PathVariable(name = "ticketId") Long ticketId,
            @RequestBody IncidentRequestDTO incidentRequestDTO) {

        IncidentTicket incidentTicket = incidentTicketService.patchIncidentTicket(ticketId, incidentRequestDTO);
        if (incidentTicket == null) {
            log.error("No IncidentTicket found with ticketId:{}", ticketId);
            throw new IncidentTicketNotFoundException(ticketId);
        }
        return incidentResponseDTOFactory.fromIncidentTicket(incidentTicket);
    }
}
