package com.priyajit.userservice.factory;

import com.priyajit.userservice.dto.UserResponseDTO;
import com.priyajit.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserResponseDTOFactory {
    public UserResponseDTO fromUser(User user) {
        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .phone(user.getPhone())
                .build();
    }
}
