package com.netflix.houserental.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Such RentalInfo")
public class RentalInfoNotFoundException extends RuntimeException{

    public RentalInfoNotFoundException() {
        super("no such RentalInfo");
    }
}
