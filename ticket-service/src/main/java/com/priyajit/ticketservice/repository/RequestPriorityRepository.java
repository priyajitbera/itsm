package com.priyajit.ticketservice.repository;

import com.priyajit.ticketservice.entity.RequestPriority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestPriorityRepository extends JpaRepository<RequestPriority, Integer> {
}
