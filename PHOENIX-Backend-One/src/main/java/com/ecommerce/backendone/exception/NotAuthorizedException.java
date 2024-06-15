package com.ecommerce.backendone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Not your data")
public class NotAuthorizedException extends RuntimeException {
}
