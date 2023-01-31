package com.priyajit.ticketservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncidentTicketResponseDTO {

    private Long ticketId;

    private String number; // eg: INC12345678

    private String templateId;

    private String title;

    private String contactId; // listed users will be maintained using seperate service

    private String primaryApplicationId; // listed applications will be maintained using a seperate service

    private String primaryApplicationInstance;

    private String symptom; // eg: GUI_ERROR, ACCESS_ISSUE

    private Integer priorityId;

    private String priority; // eg: CRITICAL-1, HIGH-2, LOW-3, Low-4

    private String description;

    private String location; // eg: Kolkata, Chennai

    private String primaryEnvironment; // eg: PROD, UAT, DEV

    private String contactType; // eg: email, phone, chat

    private String originatingGroupId;

    private String assignedGroupId;

    private String assigneeId;

    private Date createdOn;

    private Integer statusId;

    private String status;

    private Integer timeWorked; // in seconds
}
