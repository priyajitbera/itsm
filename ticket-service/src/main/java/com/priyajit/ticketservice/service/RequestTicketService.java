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

    public RequestTicket create(RequestTicketRequestDTO requestTicketRequestDTO) {

        // for new ticket being created
        // ticketId will be null, createdOn will be current Date, status will be OPEN-1
        requestTicketRequestDTO.setTicketId(null);
        requestTicketRequestDTO.setCreatedOn(new Date());
        requestTicketRequestDTO.setStatusId(1);

        RequestTicket requestTicket = requestTicketFactory.fromRequestTicketRequestDTO(requestTicketRequestDTO);

        return requestTicketRepository.save(requestTicket);
    }

    public RequestTicket get(Long ticketId) {
        return requestTicketRepository.findById(ticketId).orElse(null);
    }

    public RequestTicket updateSpecific(Long ticketId, RequestTicketRequestDTO requestTicketRequestDTO) {
        RequestTicket requestTicket = requestTicketRepository.findById(ticketId)
                .orElse(null);

        requestTicket = requestTicketFactory.fromRequestTicketRequestDTO(requestTicketRequestDTO, requestTicket);

        // set ticketId for update request
        requestTicket.setTicketId(ticketId);

        return requestTicketRepository.save(requestTicket);
    }
}
