package com.priyajit.ticketservice.repository;

import com.priyajit.ticketservice.entity.IncidentTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentTicketRepository extends JpaRepository<IncidentTicket, Long> {
}
