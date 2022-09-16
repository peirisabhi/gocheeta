package com.abhishek.gocheeta.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralException extends RuntimeException{

    private static final long serialVersionID = 1L;

    public GeneralException(String message) {
        super(message);
    }
}
