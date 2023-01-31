package com.priyajit.ticketservice.service.implementation;

import com.priyajit.ticketservice.entity.RequestStatus;
import com.priyajit.ticketservice.repository.RequestStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestStatusServiceImpl {

    @Autowired
    private RequestStatusRepository requestStatusRepository;

    private List<RequestStatus> requestStatuses;

    private void loadRequestStatuses(){
        requestStatuses = requestStatusRepository.findAll();
    }

    public RequestStatus getRequestStatusByStatusId(Integer statusId){
        if(requestStatuses == null) loadRequestStatuses();
        return requestStatuses.stream()
                .filter(requestStatus -> requestStatus.getStatusId().equals(statusId))
                .toList().get(0);
    }
}
