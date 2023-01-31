package com.priyajit.ticketservice.service;

import com.priyajit.ticketservice.dto.IncidentTicketRequestDTO;
import com.priyajit.ticketservice.entity.IncidentTicket;

public interface IncidentTicketService {

    IncidentTicket createNewIncidentTicket(IncidentTicketRequestDTO incidentTicketRequestDTO);

    IncidentTicket getIncidentTicket(Long ticketId);

    IncidentTicket patchIncidentTicket(Long ticketId, IncidentTicketRequestDTO incidentTicketRequestDTO);
}
