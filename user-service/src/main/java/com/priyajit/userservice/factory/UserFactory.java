package com.priyajit.userservice.factory;

import com.priyajit.userservice.dto.UserRequestDTO;
import com.priyajit.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    public User fromUserRequestDTO(UserRequestDTO userRequestDTO) {
        return User.builder()
                .userId(userRequestDTO.getUserId())
                .email(userRequestDTO.getEmail())
                .firstName(userRequestDTO.getFirstName())
                .lastName(userRequestDTO.getLastName())
                .userName(userRequestDTO.getUserName())
                .phone(userRequestDTO.getPhone())
                .build();
    }
}
