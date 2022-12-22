package com.priyajit.ticketservice.factory;

import com.priyajit.ticketservice.dto.IncidentRequestDTO;
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

    public IncidentTicket fromIncidentRequestDTO(IncidentRequestDTO incidentRequestDTO) {
        return IncidentTicket.builder()
                .ticketId(incidentRequestDTO.getTicketId())
                .templateId(incidentRequestDTO.getTemplateId())
                .title(incidentRequestDTO.getTitle())
                .contactId(incidentRequestDTO.getContactId())
                .primaryApplicationId(incidentRequestDTO.getPrimaryApplicationId())
                .symptom(incidentRequestDTO.getSymptom())
                .priority(incidentPriorityService.getIncidentPriorityByPriorityId(incidentRequestDTO.getPriority()))
                .description(incidentRequestDTO.getDescription())
                .location(incidentRequestDTO.getLocation())
                .primaryEnvironment(incidentRequestDTO.getPrimaryEnvironment())
                .contactType(incidentRequestDTO.getContactType())
                .originatingGroupId(incidentRequestDTO.getOriginatingGroupId())
                .assigneeId(incidentRequestDTO.getAssigneeId())
                .assignedGroupId(incidentRequestDTO.getAssignedGroupId())
                .createdOn(incidentRequestDTO.getCreatedOn())
                .status(incidentStatusService.findIncidentStatusByStatusId(1)) // initially 1 -> OPEN
                .timeWorked(0) // initially zero seconds
                .build();
    }

    /**
     * Only updates fields which are not null in incidentRequestDTO
     * @param incidentRequestDTO
     * @param incidentTicket
     * @return
     */
    public IncidentTicket fromIncidentRequestDTO(@NotNull IncidentRequestDTO incidentRequestDTO, IncidentTicket incidentTicket) {

       // only override those fields which are not null in incidentRequestDTO

        if (incidentRequestDTO.getTicketId() != null)
            incidentTicket.setTicketId(incidentRequestDTO.getTicketId());

        if (incidentRequestDTO.getTemplateId() != null)
            incidentTicket.setTemplateId(incidentRequestDTO.getTemplateId());

        if (incidentRequestDTO.getTitle() != null)
            incidentTicket.setTitle(incidentRequestDTO.getTitle());

        if (incidentRequestDTO.getContactId() != null)
            incidentTicket.setContactId(incidentRequestDTO.getContactId());

        if (incidentRequestDTO.getPrimaryApplicationId() != null)
            incidentTicket.setPrimaryApplicationId(incidentRequestDTO.getPrimaryApplicationId());

        if (incidentRequestDTO.getSymptom() != null)
            incidentTicket.setSymptom(incidentRequestDTO.getSymptom());

        if (incidentRequestDTO.getPriority() != null)
            incidentTicket.setPriority(incidentPriorityService.getIncidentPriorityByPriorityId(incidentRequestDTO.getPriority()));

        if (incidentRequestDTO.getDescription() != null)
            incidentTicket.setDescription(incidentRequestDTO.getDescription());

        if (incidentRequestDTO.getLocation() != null)
            incidentTicket.setLocation(incidentRequestDTO.getLocation());

        if (incidentRequestDTO.getPrimaryEnvironment() != null)
            incidentTicket.setPrimaryEnvironment(incidentRequestDTO.getPrimaryEnvironment());

        if (incidentRequestDTO.getContactType() != null)
            incidentTicket.setContactId(incidentRequestDTO.getContactId());

        if (incidentRequestDTO.getOriginatingGroupId() != null)
            incidentTicket.setOriginatingGroupId(incidentRequestDTO.getOriginatingGroupId());

        if(incidentRequestDTO.getAssigneeId() != null){
            incidentTicket.setAssigneeId(incidentRequestDTO.getAssigneeId());
        }

        if (incidentRequestDTO.getAssignedGroupId() != null)
            incidentTicket.setAssignedGroupId(incidentRequestDTO.getAssignedGroupId());

        if (incidentRequestDTO.getCreatedOn() != null)
            incidentTicket.setCreatedOn(incidentRequestDTO.getCreatedOn());

        if (incidentRequestDTO.getStatus() != null)
            incidentTicket.setStatus(incidentStatusService.findIncidentStatusByStatusId(incidentRequestDTO.getStatus()));

        if (incidentRequestDTO.getTimeWorked() != null)
            incidentTicket.setTimeWorked(incidentTicket.getTimeWorked());

        return incidentTicket;
    }
}
