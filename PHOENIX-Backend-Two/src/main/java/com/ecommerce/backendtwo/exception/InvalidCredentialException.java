package com.ecommerce.backendtwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid credentials")
public class InvalidCredentialException extends RuntimeException {}
