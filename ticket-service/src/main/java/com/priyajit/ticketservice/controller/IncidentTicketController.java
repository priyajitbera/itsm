package com.priyajit.ticketservice.controller;

import com.priyajit.ticketservice.dto.IncidentTicketRequestDTO;
import com.priyajit.ticketservice.dto.IncidentTicketResponseDTO;
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

    @PostMapping("/new")
    public IncidentTicketResponseDTO create(@RequestBody IncidentTicketRequestDTO incidentRequestDTO) {
        IncidentTicket incidentTicket = incidentTicketService.createNewIncidentTicket(incidentRequestDTO);
        return incidentResponseDTOFactory.fromIncidentTicket(incidentTicket);
    }

    @GetMapping("/{ticketId}")
    public IncidentTicketResponseDTO get(@PathVariable(name = "ticketId") Long ticketId) {
        IncidentTicket incidentTicket = incidentTicketService.getIncidentTicket(ticketId);
        if (incidentTicket == null) {
            log.error("No IncidentTicket found with ticketId:{}", ticketId);
            throw new IncidentTicketNotFoundException(ticketId);
        }

        return incidentResponseDTOFactory.fromIncidentTicket(incidentTicket);
    }

    @PatchMapping("/{ticketId}")
    public IncidentTicketResponseDTO patch(
            @PathVariable(name = "ticketId") Long ticketId,
            @RequestBody IncidentTicketRequestDTO incidentTicketRequestDTO) {

        IncidentTicket incidentTicket = incidentTicketService.patchIncidentTicket(ticketId, incidentTicketRequestDTO);
        if (incidentTicket == null) {
            log.error("No IncidentTicket found with ticketId:{}", ticketId);
            throw new IncidentTicketNotFoundException(ticketId);
        }
        return incidentResponseDTOFactory.fromIncidentTicket(incidentTicket);
    }
}
