package com.priyajit.ticketservice.factory;

import com.priyajit.ticketservice.dto.IncidentTicketResponseDTO;
import com.priyajit.ticketservice.entity.IncidentTicket;
import org.springframework.stereotype.Component;

@Component
public class IncidentResponseDTOFactory {

    public IncidentTicketResponseDTO fromIncidentTicket(IncidentTicket incidentTicket) {
        return IncidentTicketResponseDTO.builder()

                // format as INC<ticketId> eg: INC12345678
                .ticketId(incidentTicket.getTicketId())
                .number(incidentTicket.prefix + incidentTicket.getTicketId())
                .templateId(incidentTicket.getTemplateId())
                .title(incidentTicket.getTitle())
                .contactId(incidentTicket.getContactId())
                .primaryApplicationId(incidentTicket.getPrimaryApplicationId())
                .symptom(incidentTicket.getSymptom())

                .priorityId(incidentTicket.getPriority().getPriorityId())
                // format as <priority>-<priorityId> eg: HIGH-2
                .priority(incidentTicket.getPriority().getPriority() + "-" + incidentTicket.getPriority().getPriorityId())

                .description(incidentTicket.getDescription())
                .location(incidentTicket.getLocation())
                .primaryEnvironment(incidentTicket.getPrimaryEnvironment())
                .contactType(incidentTicket.getContactType())
                .originatingGroupId(incidentTicket.getOriginatingGroupId())
                .assigneeId(incidentTicket.getAssigneeId())
                .assignedGroupId(incidentTicket.getAssignedGroupId())
                .createdOn(incidentTicket.getCreatedOn())

                .statusId(incidentTicket.getStatus().getStatusId())
                // eg: OPEN, IN_PROGRESS etc
                .status(incidentTicket.getStatus().getStatus())

                // in seconds
                .timeWorked(incidentTicket.getTimeWorked())
                .build();
    }
}
