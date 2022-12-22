package com.priyajit.ticketservice.service;

import com.priyajit.ticketservice.dto.IncidentRequestDTO;
import com.priyajit.ticketservice.entity.IncidentTicket;
import com.priyajit.ticketservice.factory.IncidentFactory;
import com.priyajit.ticketservice.repository.IncidentTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class IncidentTicketService {

    @Autowired
    private IncidentTicketRepository incidentTicketRepository;

    @Autowired
    private IncidentStatusService incidentStatusService;

    @Autowired
    private IncidentFactory incidentFactory;

    public IncidentTicket create(IncidentRequestDTO incidentRequestDTO){
        IncidentTicket incidentTicket = incidentFactory.fromIncidentRequestDTO(incidentRequestDTO);

        // for new ticket being created set createdOn to current time and status to OPEN-1
        incidentTicket.setCreatedOn(new Date());
        incidentTicket.setStatus(incidentStatusService.findIncidentStatusByStatusId(1));

        return incidentTicketRepository.save(incidentTicket);
    }

    public IncidentTicket get(Long ticketId){
        Optional<IncidentTicket> optionalIncidentTicket = incidentTicketRepository.findById(ticketId);
        return optionalIncidentTicket.orElse(null);
    }

    /**
     * Only updates fields which are not null in incidentRequestDTO
     * @param incidentRequestDTO
     * @return updated IncidentTicket
     */
    public IncidentTicket updateSpecific(IncidentRequestDTO incidentRequestDTO) {
        Long ticketId = incidentRequestDTO.getTicketId();
        IncidentTicket incidentTicket = incidentTicketRepository.findById(ticketId).orElse(null);
        incidentTicket = incidentFactory.fromIncidentRequestDTO(incidentRequestDTO, incidentTicket);

        // restore ticketId, as primaryKey will not be changed
        incidentTicket.setTicketId(ticketId);
        return incidentTicketRepository.save(incidentTicket);
    }
}
