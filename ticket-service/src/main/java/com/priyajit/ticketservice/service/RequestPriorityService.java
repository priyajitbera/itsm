package com.priyajit.ticketservice.service;

import com.priyajit.ticketservice.entity.RequestPriority;
import com.priyajit.ticketservice.repository.RequestPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestPriorityService {

    @Autowired
    private RequestPriorityRepository requestPriorityRepository;

    private List<RequestPriority> requestPriorities;

    private void loadRequestPriorities(){
        requestPriorities = requestPriorityRepository.findAll();
    }

    public RequestPriority getRequestPriorityByPriorityId(Integer priorityId){
        if(requestPriorities == null) loadRequestPriorities();
        return requestPriorities.stream()
                .filter(requestPriority -> requestPriority.getPriorityId().equals(priorityId))
                .toList().get(0);
    }
}
