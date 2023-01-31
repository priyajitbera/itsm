package com.priyajit.ticketservice.service.implementation;

import com.priyajit.ticketservice.entity.IncidentPriority;
import com.priyajit.ticketservice.repository.IncidentPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class IncidentPriorityServiceImpl {

    @Autowired
    private IncidentPriorityRepository incidentPriorityRepository;

    private List<IncidentPriority> incidentPriorities;

    public void loadIncidentPriorities(){
        incidentPriorities = incidentPriorityRepository.findAll();
    }

    public  IncidentPriority getIncidentPriorityByPriorityId(Integer priorityId){
        if(incidentPriorities == null) loadIncidentPriorities();

        return incidentPriorities.stream()
                .filter(incidentPriority -> Objects.equals(incidentPriority.getPriorityId(), priorityId))
                .toList()
                .get(0);
    }
}
