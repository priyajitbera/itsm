package com.priyajit.ticketservice.service;

import com.priyajit.ticketservice.dto.RequestTicketRequestDTO;
import com.priyajit.ticketservice.entity.RequestTicket;
import com.priyajit.ticketservice.factory.RequestTicketFactory;
import com.priyajit.ticketservice.repository.RequestTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RequestTicketService {

    @Autowired
    private RequestTicketFactory requestTicketFactory;

    @Autowired
    private RequestTicketRepository requestTicketRepository;

    @Autowired
    private RequestStatusService requestStatusService;

    /**
     * Creates new Request Ticket
     *
     * @param requestTicketRequestDTO dto containing details to create the ticket
     * @return newly created ticket
     */
    public RequestTicket createRequestTicket(RequestTicketRequestDTO requestTicketRequestDTO) {

        // for new ticket being created
        // ticketId will be null, createdOn will be current Date, status will be OPEN-1
        requestTicketRequestDTO.setTicketId(null);
        requestTicketRequestDTO.setCreatedOn(new Date());
        requestTicketRequestDTO.setStatusId(1);

        RequestTicket requestTicket = requestTicketFactory.fromRequestTicketRequestDTO(requestTicketRequestDTO);

        return requestTicketRepository.save(requestTicket);
    }

    /**
     * Gets and existing ticket by ticketId
     *
     * @param ticketId id to find the ticket
     * @return the existing ticket if found else null
     */
    public RequestTicket getRequestTicket(Long ticketId) {
        return requestTicketRepository.findById(ticketId).orElse(null);
    }

    /**
     * Patches existing RequestTicket
     * Only updates fields which are provided i.e. not null in the dto
     *
     * @param ticketId                id of the ticket to patch
     * @param requestTicketRequestDTO dto containing details to update
     * @return updated RequestTicket if found else null
     */
    public RequestTicket patchRequestTicket(Long ticketId, RequestTicketRequestDTO requestTicketRequestDTO) {
        RequestTicket requestTicket = requestTicketRepository.findById(ticketId)
                .orElse(null);
        if (requestTicket == null) return null;

        requestTicket = requestTicketFactory.fromRequestTicketRequestDTO(requestTicketRequestDTO, requestTicket);

        // set ticketId for update request
        requestTicket.setTicketId(ticketId);

        return requestTicketRepository.save(requestTicket);
    }
}
