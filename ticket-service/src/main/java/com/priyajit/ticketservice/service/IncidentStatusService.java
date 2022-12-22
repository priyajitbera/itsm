package com.priyajit.ticketservice.service;

import com.priyajit.ticketservice.entity.IncidentStatus;
import com.priyajit.ticketservice.repository.IncidentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentStatusService {

    @Autowired
    private IncidentStatusRepository incidentStatusRepository;

    private List<IncidentStatus> incidentStatuses;

    private void loadIncidentStatuses() {
        incidentStatuses = incidentStatusRepository.findAll();
    }

    public IncidentStatus findIncidentStatusByStatusId(Integer statusId) {
        if (incidentStatuses == null) loadIncidentStatuses();

        return incidentStatuses.stream()
                .filter(incidentStatus -> incidentStatus.getStatusId().equals(statusId))
                .toList().get(0);
    }
}
