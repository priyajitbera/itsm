package com.priyajit.ticketservice.controller;

import com.priyajit.ticketservice.dto.RequestTicketRequestDTO;
import com.priyajit.ticketservice.dto.RequestTicketResponseDTO;
import com.priyajit.ticketservice.entity.RequestTicket;
import com.priyajit.ticketservice.factory.RequestTicketResponseDTOFactory;
import com.priyajit.ticketservice.service.RequestTicketService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/req")
public class RequestTicketController {

    @Autowired
    private RequestTicketService requestTicketService;

    @Autowired
    private RequestTicketResponseDTOFactory requestTicketResponseDTOFactory;

    @PostMapping
    public RequestTicketResponseDTO create(@RequestBody RequestTicketRequestDTO requestRequestDTO) {
        RequestTicket requestTicket = requestTicketService.create(requestRequestDTO);
        return requestTicketResponseDTOFactory.fromRequestTicket(requestTicket);
    }

    @GetMapping("/{ticketId}")
    public RequestTicketResponseDTO get(@PathVariable(name = "ticketId") Long ticketId) {
        RequestTicket requestTicket = requestTicketService.get(ticketId);
        if (requestTicket == null)
            throw new EntityNotFoundException("No RequestTicket found with ticketId" + ticketId);
        return requestTicketResponseDTOFactory.fromRequestTicket(requestTicket);
    }

    @PatchMapping("/{ticketId}")
    public RequestTicketResponseDTO patch(
            @PathVariable(name = "ticketId") Long ticketId,
            @RequestBody RequestTicketRequestDTO requestTicketRequestDTO) {

        RequestTicket requestTicket = requestTicketService.updateSpecific(ticketId, requestTicketRequestDTO);
        return requestTicketResponseDTOFactory.fromRequestTicket(requestTicket);
    }
}
