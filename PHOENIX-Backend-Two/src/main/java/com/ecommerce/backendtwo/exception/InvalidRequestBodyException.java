package com.ecommerce.backendtwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid request body")
public class InvalidRequestBodyException extends RuntimeException {
}
