package com.priyajit.ticketservice.factory;

import com.priyajit.ticketservice.dto.IncidentTicketRequestDTO;
import com.priyajit.ticketservice.entity.IncidentTicket;
import com.priyajit.ticketservice.service.IncidentPriorityService;
import com.priyajit.ticketservice.service.IncidentStatusService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncidentFactory {

    @Autowired
    private IncidentPriorityService incidentPriorityService;

    @Autowired
    private IncidentStatusService incidentStatusService;

    public IncidentTicket fromIncidentTicketRequestDTO(IncidentTicketRequestDTO incidentTicketRequestDTO) {
        return IncidentTicket.builder()
                .ticketId(incidentTicketRequestDTO.getTicketId())
                .templateId(incidentTicketRequestDTO.getTemplateId())
                .title(incidentTicketRequestDTO.getTitle())
                .contactId(incidentTicketRequestDTO.getContactId())
                .primaryApplicationId(incidentTicketRequestDTO.getPrimaryApplicationId())
                .symptom(incidentTicketRequestDTO.getSymptom())
                .priority(incidentPriorityService.getIncidentPriority(incidentTicketRequestDTO.getPriority()))
                .description(incidentTicketRequestDTO.getDescription())
                .location(incidentTicketRequestDTO.getLocation())
                .primaryEnvironment(incidentTicketRequestDTO.getPrimaryEnvironment())
                .contactType(incidentTicketRequestDTO.getContactType())
                .originatingGroupId(incidentTicketRequestDTO.getOriginatingGroupId())
                .assigneeId(incidentTicketRequestDTO.getAssigneeId())
                .assignedGroupId(incidentTicketRequestDTO.getAssignedGroupId())
                .createdOn(incidentTicketRequestDTO.getCreatedOn())
                .status(incidentStatusService.getIncidentStatus(1)) // initially 1 -> OPEN
                .timeWorked(0) // initially zero seconds
                .build();
    }

    /**
     * Only updates fields which are not null in incidentTicketRequestDTO
     *
     * @param incidentTicketRequestDTO
     * @param incidentTicket
     * @return
     */
    public IncidentTicket fromIncidentTicketRequestDTO(@NotNull IncidentTicketRequestDTO incidentTicketRequestDTO, IncidentTicket incidentTicket) {

        // only override those fields which are not null in incidentTicketRequestDTO

        if (incidentTicketRequestDTO.getTicketId() != null)
            incidentTicket.setTicketId(incidentTicketRequestDTO.getTicketId());

        if (incidentTicketRequestDTO.getTemplateId() != null)
            incidentTicket.setTemplateId(incidentTicketRequestDTO.getTemplateId());

        if (incidentTicketRequestDTO.getTitle() != null)
            incidentTicket.setTitle(incidentTicketRequestDTO.getTitle());

        if (incidentTicketRequestDTO.getContactId() != null)
            incidentTicket.setContactId(incidentTicketRequestDTO.getContactId());

        if (incidentTicketRequestDTO.getPrimaryApplicationId() != null)
            incidentTicket.setPrimaryApplicationId(incidentTicketRequestDTO.getPrimaryApplicationId());

        if (incidentTicketRequestDTO.getSymptom() != null)
            incidentTicket.setSymptom(incidentTicketRequestDTO.getSymptom());

        if (incidentTicketRequestDTO.getPriority() != null)
            incidentTicket.setPriority(incidentPriorityService.getIncidentPriority(incidentTicketRequestDTO.getPriority()));

        if (incidentTicketRequestDTO.getDescription() != null)
            incidentTicket.setDescription(incidentTicketRequestDTO.getDescription());

        if (incidentTicketRequestDTO.getLocation() != null)
            incidentTicket.setLocation(incidentTicketRequestDTO.getLocation());

        if (incidentTicketRequestDTO.getPrimaryEnvironment() != null)
            incidentTicket.setPrimaryEnvironment(incidentTicketRequestDTO.getPrimaryEnvironment());

        if (incidentTicketRequestDTO.getContactType() != null)
            incidentTicket.setContactId(incidentTicketRequestDTO.getContactId());

        if (incidentTicketRequestDTO.getOriginatingGroupId() != null)
            incidentTicket.setOriginatingGroupId(incidentTicketRequestDTO.getOriginatingGroupId());

        if (incidentTicketRequestDTO.getAssigneeId() != null) {
            incidentTicket.setAssigneeId(incidentTicketRequestDTO.getAssigneeId());
        }

        if (incidentTicketRequestDTO.getAssignedGroupId() != null)
            incidentTicket.setAssignedGroupId(incidentTicketRequestDTO.getAssignedGroupId());

        if (incidentTicketRequestDTO.getCreatedOn() != null)
            incidentTicket.setCreatedOn(incidentTicketRequestDTO.getCreatedOn());

        if (incidentTicketRequestDTO.getStatus() != null)
            incidentTicket.setStatus(incidentStatusService.getIncidentStatus(incidentTicketRequestDTO.getStatus()));

        if (incidentTicketRequestDTO.getTimeWorked() != null)
            incidentTicket.setTimeWorked(incidentTicket.getTimeWorked());

        return incidentTicket;
    }
}
