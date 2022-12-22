package com.priyajit.ticketservice.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncidentRequestDTO {

    private Long ticketId;

    private String templateId;

    private String title;

    private String contactId; // listed users will be maintained using seperate service

    private String primaryApplicationId; // listed applications will be maintained using a seperate service

    private String primaryApplicationInstance;

    private String symptom; // eg: GUI_ERROR, ACCESS_ISSUE

    private Integer priority; // eg: Critical 1, High 2, Medium 3, Low 4

    private String description;

    private String location; // eg: Kolkata, Chennai

    private String primaryEnvironment; // eg: PROD, UAT, DEV

    private String contactType; // eg: email, phone, chat

    private String originatingGroupId;

    private String assignedGroupId;

    private String assigneeId;

    private Date createdOn;

    private Integer status;

    private Integer timeWorked; // in seconds

    public String toJsonString(){
        String jsonString = null;
        try{
            jsonString = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(this);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return jsonString;
    }
}
/*
Sample JSON request body
{
  "templateId" : "",
  "title" : "Login Issue",
  "contactId" : "pb11345",
  "primaryApplicationId" : "1921238",
  "primaryApplicationInstance" : null,
  "symptom" : "GUI_ERROR",
  "priority" : 2,
  "description" : "Unable to login using below link /n google.come/login",
  "location" : "Kolkata",
  "primaryEnvironment" : "PROD",
  "contactType" : "EMAIL",
  "originatingGroupId" : "",
  "assignedGroupId" : "CSR-IT",
  "assigneeId" : "",
  "status" : null
}
*/