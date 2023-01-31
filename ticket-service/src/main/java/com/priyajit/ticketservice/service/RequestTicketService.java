package com.priyajit.ticketservice.service;

import com.priyajit.ticketservice.dto.RequestTicketRequestDTO;
import com.priyajit.ticketservice.entity.RequestTicket;

public interface RequestTicketService {

    RequestTicket createNewRequestTicket(RequestTicketRequestDTO requestTicketRequestDTO);
    RequestTicket getRequestTicket(Long ticketId);

    RequestTicket patchRequestTicket(Long ticket, RequestTicketRequestDTO requestTicketRequestDTO);
}
