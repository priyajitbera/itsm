package com.priyajit.ticketservice.repository;

import com.priyajit.ticketservice.entity.IncidentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentStatusRepository extends JpaRepository<IncidentStatus, Integer> {
}
