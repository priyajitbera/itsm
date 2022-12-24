package com.priyajit.ticketservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IncidentTicketNotFoundException extends RuntimeException {

    public IncidentTicketNotFoundException(Long ticketId) {
        super(String.format("No IncidentTicket found with ticketId:%d", ticketId));
    }
}
