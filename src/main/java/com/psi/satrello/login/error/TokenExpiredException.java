package com.psi.satrello.login.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class TokenExpiredException extends RuntimeException {

    private HttpStatus status;

    public TokenExpiredException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
