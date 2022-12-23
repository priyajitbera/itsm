package com.priyajit.ticketservice.repository;

import com.priyajit.ticketservice.entity.RequestTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestTicketRepository extends JpaRepository<RequestTicket, Long> {
}
