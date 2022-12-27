package com.priyajit.userservice.controller;

import com.priyajit.userservice.dto.AddMemberRequestDTO;
import com.priyajit.userservice.dto.TeamRequestDTO;
import com.priyajit.userservice.dto.TeamResponseDTO;
import com.priyajit.userservice.entity.Team;
import com.priyajit.userservice.entity.User;
import com.priyajit.userservice.exception.TeamNotFoundException;
import com.priyajit.userservice.factory.TeamResponseDTOFactory;
import com.priyajit.userservice.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamResponseDTOFactory teamResponseDTOFactory;

    @PostMapping
    public TeamResponseDTO createTeam(@RequestBody TeamRequestDTO teamRequestDTO) {
        Team team = teamService.createTeam(teamRequestDTO);
        return teamResponseDTOFactory.fromTeam(team);
    }

    @GetMapping("/{teamId}")
    public TeamResponseDTO getTeam(@PathVariable("teamId") Long teamId) {
        Team team = teamService.getTeam(teamId);
        if (team == null) throw new TeamNotFoundException(teamId);
        return teamResponseDTOFactory.fromTeam(team);
    }

    @GetMapping("/getMembers/{teamId}")
    public List<User> getMembers(@PathVariable(name = "teamId") Long teamId) {
        return teamService.getMembers(teamId);
    }

    @PostMapping("/addMember")
    public void addMember(@RequestBody AddMemberRequestDTO addMemberRequestDTO) {
        teamService.addMember(addMemberRequestDTO);
    }

    @GetMapping("/getTeams/{userId}")
    public List<Team> getTeamsOfUser(@PathVariable("userId") Long userId) {
        return teamService.getTeamsByUserId(userId);
    }
}
