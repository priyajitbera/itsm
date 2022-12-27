package com.priyajit.userservice.factory;

import com.priyajit.userservice.dto.TeamRequestDTO;
import com.priyajit.userservice.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamFactory {

    public Team fromTeamRequestDTO(TeamRequestDTO teamRequestDTO) {
        return Team.builder()
                .teamId(teamRequestDTO.getTeamId())
                .name(teamRequestDTO.getName())
                .build();
    }
}
