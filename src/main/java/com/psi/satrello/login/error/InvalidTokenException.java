package com.psi.satrello.login.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class InvalidTokenException extends RuntimeException {

    private HttpStatus status;

    public InvalidTokenException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
