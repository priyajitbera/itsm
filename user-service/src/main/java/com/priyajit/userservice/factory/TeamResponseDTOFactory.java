package com.priyajit.userservice.factory;

import com.priyajit.userservice.dto.TeamResponseDTO;
import com.priyajit.userservice.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamResponseDTOFactory {

    public TeamResponseDTO fromTeam(Team team) {
        return TeamResponseDTO.builder()
                .teamId(team.getTeamId())
                .name(team.getName())
                .build();
    }
}
