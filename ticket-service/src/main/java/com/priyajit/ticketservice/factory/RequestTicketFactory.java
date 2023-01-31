package com.priyajit.ticketservice.factory;

import com.priyajit.ticketservice.dto.RequestTicketRequestDTO;
import com.priyajit.ticketservice.entity.RequestTicket;
import com.priyajit.ticketservice.service.RequestCategoryService;
import com.priyajit.ticketservice.service.RequestPriorityService;
import com.priyajit.ticketservice.service.RequestStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestTicketFactory {

    @Autowired
    private RequestPriorityService requestPriorityService;

    @Autowired
    private RequestCategoryService requestCategoryService;

    @Autowired
    private RequestStatusService requestStatusService;

    /***
     * Creates an instance RequestTicket using requestTicketRequestDTO
     * @param requestTicketRequestDTO
     * @return returns new instance RequestTicket
     */
    public RequestTicket fromRequestTicketRequestDTO(RequestTicketRequestDTO requestTicketRequestDTO) {
        return RequestTicket.builder()
                .ticketId(requestTicketRequestDTO.getTicketId())
                .templateId(requestTicketRequestDTO.getTemplateId())
                .title(requestTicketRequestDTO.getTitle())
                .requesterId(requestTicketRequestDTO.getRequesterId())
                .primaryApplicationId(requestTicketRequestDTO.getPrimaryApplicationId())
                .primaryApplicationInstance(requestTicketRequestDTO.getPrimaryApplicationInstance())
                .priority(requestPriorityService.getRequestPriority(requestTicketRequestDTO.getPriorityId()))
                .requestCategory(requestCategoryService.getRequestCategory(requestTicketRequestDTO.getRequestCategoryId()))
                .description(requestTicketRequestDTO.getDescription())
                .location(requestTicketRequestDTO.getLocation())
                .primaryEnvironment(requestTicketRequestDTO.getPrimaryEnvironment())
                .contactType(requestTicketRequestDTO.getContactType())
                .originatingGroupId(requestTicketRequestDTO.getOriginatingGroupId())
                .assignedGroupId(requestTicketRequestDTO.getAssignedGroupId())
                .assigneeId(requestTicketRequestDTO.getAssigneeId())
                .createdOn(requestTicketRequestDTO.getCreatedOn())
                .status(requestStatusService.getRequestStatus(requestTicketRequestDTO.getStatusId()))
                .timeWorked(requestTicketRequestDTO.getTimeWorked())
                .build();
    }

    /***
     * Overrides fields of requestTicket from requestTicketRequestDTO
     * excluding the fields which are set to null in requestTicketRequestDTO
     * @param requestTicketRequestDTO
     * @param requestTicket
     * @return returns the same requestTicket instance passed as parameter after updating fields
     */
    public RequestTicket fromRequestTicketRequestDTO(RequestTicketRequestDTO requestTicketRequestDTO, RequestTicket requestTicket) {

        // ticketId
        if (requestTicketRequestDTO.getTicketId() != null)
            requestTicket.setTicketId(requestTicketRequestDTO.getTicketId());

        // templateId
        if (requestTicketRequestDTO.getTemplateId() != null)
            requestTicket.setTicketId(requestTicketRequestDTO.getTicketId());

        // title
        if (requestTicketRequestDTO.getTitle() != null)
            requestTicket.setTitle(requestTicketRequestDTO.getTitle());

        // requesterId
        if (requestTicketRequestDTO.getRequesterId() != null)
            requestTicket.setRequesterId(requestTicketRequestDTO.getRequesterId());

        // primaryApplicationId
        if (requestTicketRequestDTO.getPrimaryApplicationId() != null)
            requestTicket.setPrimaryApplicationId(requestTicketRequestDTO.getPrimaryApplicationId());

        // primaryApplicationInstance
        if (requestTicketRequestDTO.getPrimaryApplicationInstance() != null)
            requestTicket.setPrimaryApplicationInstance(requestTicketRequestDTO.getPrimaryApplicationInstance());

        // priorityId
        if (requestTicketRequestDTO.getPriorityId() != null)
            requestTicket.setPriority(
                    requestPriorityService.getRequestPriority(requestTicketRequestDTO.getPriorityId()));

        // categoryId
        if (requestTicketRequestDTO.getRequestCategoryId() != null)
            requestTicket.setRequestCategory(
                    requestCategoryService.getRequestCategory(requestTicketRequestDTO.getRequestCategoryId()));

        // description
        if (requestTicketRequestDTO.getDescription() != null)
            requestTicket.setDescription(requestTicketRequestDTO.getDescription());

        // location
        if (requestTicketRequestDTO.getLocation() != null)
            requestTicket.setLocation(requestTicketRequestDTO.getLocation());

        // primaryEnvironment
        if (requestTicketRequestDTO.getPrimaryEnvironment() != null)
            requestTicket.setPrimaryEnvironment(requestTicketRequestDTO.getPrimaryEnvironment());

        // contactType
        if (requestTicketRequestDTO.getContactType() != null)
            requestTicket.setContactType(requestTicketRequestDTO.getContactType());

        // originatingGroupId
        if (requestTicketRequestDTO.getOriginatingGroupId() != null)
            requestTicket.setOriginatingGroupId(requestTicketRequestDTO.getOriginatingGroupId());

        // assignedGroupId
        if (requestTicketRequestDTO.getAssignedGroupId() != null)
            requestTicket.setAssignedGroupId(requestTicketRequestDTO.getAssignedGroupId());

        // assigneeId
        if (requestTicketRequestDTO.getAssigneeId() != null)
            requestTicket.setAssigneeId(requestTicketRequestDTO.getAssigneeId());

        // createdOn
        if (requestTicketRequestDTO.getCreatedOn() != null)
            requestTicket.setCreatedOn(requestTicketRequestDTO.getCreatedOn());

        // statusId
        if (requestTicketRequestDTO.getStatusId() != null)
            requestTicket.setStatus(
                    requestStatusService.getRequestStatus(
                            requestTicketRequestDTO.getStatusId()));

        // timeWorked
        if (requestTicketRequestDTO.getTimeWorked() != null)
            requestTicket.setTimeWorked(requestTicketRequestDTO.getTimeWorked());

        return requestTicket;
    }
}
