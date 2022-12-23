package com.priyajit.ticketservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestPriority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priorityId;

    @Column(length = 20)
    private String priority;
}
