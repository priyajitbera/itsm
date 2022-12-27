package com.priyajit.userservice.service;

import com.priyajit.userservice.dto.UserRequestDTO;
import com.priyajit.userservice.entity.User;
import com.priyajit.userservice.factory.UserFactory;
import com.priyajit.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFactory userFactory;

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequestDTO userRequestDTO) {
        User user = userFactory.fromUserRequestDTO(userRequestDTO);

        // for new user set id to null
        user.setUserId(null);

        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
