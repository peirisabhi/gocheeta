package com.abhishek.gocheeta.adminservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class DataNotFoundException extends RuntimeException{

    private static final long serialVersionID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
