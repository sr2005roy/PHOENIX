package com.ecommerce.backendtwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FailedRequestException extends RuntimeException {
    public FailedRequestException(String message) {
        super(message);
    }
}
