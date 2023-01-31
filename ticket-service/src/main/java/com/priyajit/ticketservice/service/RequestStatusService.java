package com.priyajit.ticketservice.service;

import com.priyajit.ticketservice.entity.RequestStatus;

public interface RequestStatusService {

    RequestStatus getRequestStatus(Integer statusId);
}
