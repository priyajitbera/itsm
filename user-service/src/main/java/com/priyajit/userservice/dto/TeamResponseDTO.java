package com.priyajit.userservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamResponseDTO {

    private Long teamId;

    private String name;
}
