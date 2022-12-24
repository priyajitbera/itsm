package com.priyajit.ticketservice.controller;

import com.priyajit.ticketservice.dto.RequestTicketRequestDTO;
import com.priyajit.ticketservice.dto.RequestTicketResponseDTO;
import com.priyajit.ticketservice.entity.RequestTicket;
import com.priyajit.ticketservice.exception.RequestTicketNotFoundException;
import com.priyajit.ticketservice.factory.RequestTicketResponseDTOFactory;
import com.priyajit.ticketservice.service.RequestTicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/req")
@Slf4j
public class RequestTicketController {

    @Autowired
    private RequestTicketService requestTicketService;

    @Autowired
    private RequestTicketResponseDTOFactory requestTicketResponseDTOFactory;

    @PostMapping
    public RequestTicketResponseDTO create(@RequestBody RequestTicketRequestDTO requestRequestDTO) {
        RequestTicket requestTicket = requestTicketService.createRequestTicket(requestRequestDTO);
        return requestTicketResponseDTOFactory.fromRequestTicket(requestTicket);
    }

    @GetMapping("/{ticketId}")
    public RequestTicketResponseDTO get(@PathVariable(name = "ticketId") Long ticketId) {
        RequestTicket requestTicket = requestTicketService.getRequestTicket(ticketId);
        if (requestTicket == null) {
            log.error("No RequestTicket found with ticketId:{}", ticketId);
            throw new RequestTicketNotFoundException(ticketId);
        }

        return requestTicketResponseDTOFactory.fromRequestTicket(requestTicket);
    }

    @PatchMapping("/{ticketId}")
    public RequestTicketResponseDTO patch(
            @PathVariable(name = "ticketId") Long ticketId,
            @RequestBody RequestTicketRequestDTO requestTicketRequestDTO) {

        RequestTicket requestTicket = requestTicketService.patchRequestTicket(ticketId, requestTicketRequestDTO);
        if (requestTicket == null) {
            log.error("No RequestTicket found with ticketId:{}", ticketId);
            throw new RequestTicketNotFoundException(ticketId);
        }
        return requestTicketResponseDTOFactory.fromRequestTicket(requestTicket);
    }
}
