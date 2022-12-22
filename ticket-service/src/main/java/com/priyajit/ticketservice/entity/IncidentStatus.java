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
public class IncidentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId;

    @Column(length = 20)
    private String status;
}
