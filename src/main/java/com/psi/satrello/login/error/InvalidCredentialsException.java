package com.psi.satrello.login.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException(String message) {
        super(message);
    }

}
