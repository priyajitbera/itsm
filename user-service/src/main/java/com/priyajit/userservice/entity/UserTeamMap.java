package com.priyajit.userservice.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTeamMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTeamMapId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "fk__user__user_team_map"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "teamId", foreignKey = @ForeignKey(name = "fk__team__user_team_map"))
    private Team team;
}
