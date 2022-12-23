package com.priyajit.ticketservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestTicketRequestDTO {
    private Long ticketId;

    private String templateId;

    private String title;

    private String requesterId; // listed users will be maintained using separate service

    private String primaryApplicationId; // listed applications will be maintained using a seperate service

    private String primaryApplicationInstance;

    private Integer priorityId; // eg: Critical 1, High 2, Medium 3, Low 4

    private Integer requestCategoryId;

    private String description;

    private String location; // eg: Kolkata, Chennai

    private String primaryEnvironment; // eg: PROD, UAT, DEV

    private String contactType; // eg: email, phone, chat

    private String originatingGroupId;

    private String assignedGroupId;

    private String assigneeId;

    private Date createdOn;

    private Integer statusId;

    private Integer timeWorked; // in seconds
}
