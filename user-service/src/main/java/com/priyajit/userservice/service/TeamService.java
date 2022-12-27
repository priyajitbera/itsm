package com.priyajit.userservice.service;

import com.priyajit.userservice.dto.AddMemberRequestDTO;
import com.priyajit.userservice.dto.TeamRequestDTO;
import com.priyajit.userservice.entity.Team;
import com.priyajit.userservice.entity.User;
import com.priyajit.userservice.entity.UserTeamMap;
import com.priyajit.userservice.exception.TeamNotFoundException;
import com.priyajit.userservice.exception.UserNotFoundException;
import com.priyajit.userservice.factory.TeamFactory;
import com.priyajit.userservice.repository.TeamRepository;
import com.priyajit.userservice.repository.UserRepository;
import com.priyajit.userservice.repository.UserTeamMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamService {

    @Autowired
    private TeamFactory teamFactory;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserTeamMapRepository userTeamMapRepository;

    @Autowired
    private UserRepository userRepository;

    public Team createTeam(TeamRequestDTO teamRequestDTO) {
        Team team = teamFactory.fromTeamRequestDTO(teamRequestDTO);

        // for new team set teamId to null
        team.setTeamId(null);

        return teamRepository.save(team);
    }

    public Team getTeam(Long teamId) {
        return teamRepository.findById(teamId).orElse(null);
    }

    public void addMember(AddMemberRequestDTO addMemberRequestDTO) {
        Long userId = addMemberRequestDTO.getUserId();
        Long teamId = addMemberRequestDTO.getTeamId();
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new TeamNotFoundException(teamId));

        UserTeamMap userTeamMap = UserTeamMap.builder().user(user).team(team).build();
        userTeamMapRepository.save(userTeamMap);
    }

    public List<User> getMembers(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new TeamNotFoundException(teamId));
        List<UserTeamMap> userTeamMapList = userTeamMapRepository.findByTeam(team);
        return userTeamMapList.stream().map(UserTeamMap::getUser).toList();
    }

    public List<Team> getTeamsByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        List<UserTeamMap> userTeamMapList = userTeamMapRepository.findByUser(user);
        return userTeamMapList.stream().map(UserTeamMap::getTeam).toList();
    }
}
