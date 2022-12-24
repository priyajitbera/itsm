package com.priyajit.ticketservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RequestTicketNotFoundException extends RuntimeException {

    public RequestTicketNotFoundException(Long ticketId) {
        super(String.format("No RequestTicket found with ticketId:%d", ticketId));
    }
}
