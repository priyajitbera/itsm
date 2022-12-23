package com.priyajit.ticketservice.repository;

import com.priyajit.ticketservice.entity.RequestCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestCategoryRepository extends JpaRepository<RequestCategory, Long> {
}
