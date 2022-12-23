package com.priyajit.ticketservice.repository;

import com.priyajit.ticketservice.entity.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestStatusRepository extends JpaRepository<RequestStatus, Long> {
}
