package com.priyajit.ticketservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidentTicket{
    @Transient
    public final String prefix = "INC";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Column(length = 20)
    private String templateId;

    @Column(length = 100, columnDefinition = "TEXT")
    private String title;

    @Column(length = 20)
    private String contactId; // listed users will be maintained using seperate service

    @Column(length = 20)
    private String primaryApplicationId; // listed applications will be maintained using a seperate service

    @Column(length = 20)
    private String primaryApplicationInstance;

    @Column(length = 20)
    private String symptom; // eg: GUI_ERROR, ACCESS_ISSUE

    @OneToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "priorityId", foreignKey = @ForeignKey(name="fk__incident_priority__incident_ticket"))
    private IncidentPriority priority; // eg: Critical 1, High 2, Medium 3, Low 4

    @Column(length = 2000, columnDefinition = "TEXT")
    private String description;

    @Column(length = 20)
    private String location; // eg: Kolkata, Chennai

    @Column(length = 20)
    private String primaryEnvironment; // eg: PROD, UAT, DEV

    @Column(length = 20)
    private String contactType; // eg: email, phone, chat

    @Column(length = 20)
    private String originatingGroupId;

    @Column(length = 20)
    private String assignedGroupId;

    @Column(length = 20)
    private String assigneeId;

    @Column(columnDefinition = "DATETIME")
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "statusId", foreignKey = @ForeignKey(name="fk__incident_status__incident_ticket"))
    private IncidentStatus status;

    private Integer timeWorked; // in seconds
}
