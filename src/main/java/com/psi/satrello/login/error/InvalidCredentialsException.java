package com.psi.satrello.login.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class InvalidCredentialsException extends RuntimeException {

    private HttpStatus status;

    public InvalidCredentialsException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
