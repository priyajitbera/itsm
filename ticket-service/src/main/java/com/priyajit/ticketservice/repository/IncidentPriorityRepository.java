package com.priyajit.ticketservice.repository;

import com.priyajit.ticketservice.entity.IncidentPriority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentPriorityRepository extends JpaRepository<IncidentPriority, Integer> {

}
