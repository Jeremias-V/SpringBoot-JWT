package com.psi.satrello.login.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class TokenExpiredException extends RuntimeException {

    public TokenExpiredException(String message) {
        super(message);
    }

}
