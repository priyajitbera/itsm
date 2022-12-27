package com.priyajit.userservice.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddMemberRequestDTO {
    Long teamId;
    Long userId;
}
