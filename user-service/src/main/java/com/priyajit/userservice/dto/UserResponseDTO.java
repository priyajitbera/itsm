package com.priyajit.userservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private Long userId;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
}
