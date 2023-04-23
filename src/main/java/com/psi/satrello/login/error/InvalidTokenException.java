package com.psi.satrello.login.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException(String message) {
        super(message);
    }

}
