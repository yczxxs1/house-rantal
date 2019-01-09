package com.netflix.houserental.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Such User")
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String userId) {
        super("no such User : "+userId);
    }
}
