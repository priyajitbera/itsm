package com.priyajit.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(Long teamId) {
        super(String.format("No Team found with teamId:%d", teamId));
    }
}
