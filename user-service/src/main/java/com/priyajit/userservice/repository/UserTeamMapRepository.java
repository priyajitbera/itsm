package com.priyajit.userservice.repository;

import com.priyajit.userservice.entity.Team;
import com.priyajit.userservice.entity.User;
import com.priyajit.userservice.entity.UserTeamMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTeamMapRepository extends JpaRepository<UserTeamMap, Long> {

    List<UserTeamMap> findByTeam(Team team);

    List<UserTeamMap> findByUser(User user);
}
