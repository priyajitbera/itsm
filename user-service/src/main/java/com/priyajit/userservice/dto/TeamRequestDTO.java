package com.priyajit.userservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamRequestDTO {

    private Long teamId;

    private String name;
}
