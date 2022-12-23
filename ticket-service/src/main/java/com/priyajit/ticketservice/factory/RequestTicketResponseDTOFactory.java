package com.priyajit.ticketservice.factory;

import com.priyajit.ticketservice.dto.RequestTicketResponseDTO;
import com.priyajit.ticketservice.entity.RequestTicket;
import org.springframework.stereotype.Component;

@Component
public class RequestTicketResponseDTOFactory {
    public RequestTicketResponseDTO fromRequestTicket(RequestTicket requestTicket) {
        return RequestTicketResponseDTO.builder()
                .ticketId(requestTicket.getTicketId())

                // format as REQ<ticketId> eg: REQ0012345678
                .number(RequestTicket.prefix + String.format("%010d",requestTicket.getTicketId()))

                .templateId(requestTicket.getTemplateId())
                .title(requestTicket.getTitle())
                .requesterId(requestTicket.getRequesterId())
                .primaryApplicationId(requestTicket.getPrimaryApplicationId())
                .primaryApplicationInstance(requestTicket.getPrimaryApplicationInstance())

                .priorityId(requestTicket.getPriority().getPriorityId())
                .priority(requestTicket.getPriority().getPriority())

                .requestCategoryId(requestTicket.getRequestCategory().getCategoryId())
                .requestCategory(requestTicket.getRequestCategory().getCategory())

                .description(requestTicket.getDescription())
                .location(requestTicket.getLocation())
                .primaryEnvironment(requestTicket.getPrimaryEnvironment())
                .contactType(requestTicket.getContactType())
                .originatingGroupId(requestTicket.getOriginatingGroupId())
                .assignedGroupId(requestTicket.getAssignedGroupId())
                .assigneeId(requestTicket.getAssigneeId())
                .createdOn(requestTicket.getCreatedOn())
                .statusId(requestTicket.getStatus().getStatusId())
                .status(requestTicket.getStatus().getStatus())
                .timeWorked(requestTicket.getTimeWorked())
                .build();
    }
}
