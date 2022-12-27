package com.priyajit.userservice.controller;

import com.priyajit.userservice.dto.UserRequestDTO;
import com.priyajit.userservice.dto.UserResponseDTO;
import com.priyajit.userservice.entity.User;
import com.priyajit.userservice.exception.UserNotFoundException;
import com.priyajit.userservice.factory.UserResponseDTOFactory;
import com.priyajit.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserResponseDTOFactory userResponseDTOFactory;

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO) {
        User user = userService.createUser(userRequestDTO);
        return userResponseDTOFactory.fromUser(user);
    }

    @GetMapping("/{userId}")
    public UserResponseDTO getUser(@PathVariable(name = "userId") Long userId) {
        User user = userService.getUser(userId);
        if (user == null) throw new UserNotFoundException(userId);
        return userResponseDTOFactory.fromUser(user);
    }

}
