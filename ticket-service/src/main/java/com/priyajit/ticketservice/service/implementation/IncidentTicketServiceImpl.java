package com.priyajit.ticketservice.service.implementation;

import com.priyajit.ticketservice.dto.IncidentTicketRequestDTO;
import com.priyajit.ticketservice.entity.IncidentTicket;
import com.priyajit.ticketservice.factory.IncidentFactory;
import com.priyajit.ticketservice.repository.IncidentTicketRepository;
import com.priyajit.ticketservice.service.IncidentStatusService;
import com.priyajit.ticketservice.service.IncidentTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IncidentTicketServiceImpl implements IncidentTicketService {

    @Autowired
    private IncidentTicketRepository incidentTicketRepository;

    @Autowired
    private IncidentStatusService incidentStatusService;

    @Autowired
    private IncidentFactory incidentFactory;

    /**
     * Creates new Incident Ticket
     *
     * @param incidentTicketRequestDTO dto containing detail to create the ticket
     * @return newly created IncidentTicket
     */
    public IncidentTicket createNewIncidentTicket(IncidentTicketRequestDTO incidentTicketRequestDTO) {
        IncidentTicket incidentTicket = incidentFactory.fromIncidentTicketRequestDTO(incidentTicketRequestDTO);

        // for new ticket being created set createdOn to current time and status to OPEN-1
        incidentTicket.setCreatedOn(new Date());
        incidentTicket.setStatus(incidentStatusService.getIncidentStatus(1));

        return incidentTicketRepository.save(incidentTicket);
    }

    /**
     * Gets an existing ticket by ticketId
     *
     * @param ticketId id to find the ticket
     * @return existing ticket if found else null
     */
    public IncidentTicket getIncidentTicket(Long ticketId) {
        return incidentTicketRepository.findById(ticketId).orElse(null);
    }

    /**
     * Patches existing IncidentTicket
     * Only updates fields which are provided i.e. not null in the dto
     *
     * @param ticketId                 id of the ticket to patch
     * @param incidentTicketRequestDTO dto containing details for the update
     * @return updated IncidentTicket if found else null
     */
    public IncidentTicket patchIncidentTicket(Long ticketId, IncidentTicketRequestDTO incidentTicketRequestDTO) {
        IncidentTicket incidentTicket = incidentTicketRepository.findById(ticketId).orElse(null);
        if (incidentTicket == null) return null;

        incidentTicket = incidentFactory.fromIncidentTicketRequestDTO(incidentTicketRequestDTO, incidentTicket);

        // set ticketId for update
        incidentTicket.setTicketId(ticketId);
        return incidentTicketRepository.save(incidentTicket);
    }
}
