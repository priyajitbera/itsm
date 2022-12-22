package com.priyajit.ticketservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncidentPriority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priorityId;

    @Column(length = 20)
    private String priority;


}
