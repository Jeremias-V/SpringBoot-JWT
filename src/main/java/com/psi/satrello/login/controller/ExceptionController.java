package com.psi.satrello.login.controller;

import com.psi.satrello.login.error.InvalidCredentialsException;
import com.psi.satrello.login.error.InvalidTokenException;
import com.psi.satrello.login.error.TokenExpiredException;
import com.psi.satrello.login.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    // TODO: Review why doesn't this exception gets captured by the rest controller advice.
    @ExceptionHandler(value = TokenExpiredException.class)
    public ResponseEntity<ExceptionModel> tokenExpiredHandler(TokenExpiredException ex) {
        ExceptionModel error = new ExceptionModel(ex.getMessage(), ex.getStatus().value());
        return new ResponseEntity<>(error, ex.getStatus());
    }

    // TODO: Review if it's the spring security filter so that this exception handler works.
    @ExceptionHandler(value = InvalidTokenException.class)
    public ResponseEntity<ExceptionModel> invalidTokenHandler(InvalidTokenException ex) {
        ExceptionModel error = new ExceptionModel(ex.getMessage(), ex.getStatus().value());
        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(value = InvalidCredentialsException.class)
    public ResponseEntity<ExceptionModel> invalidCredentialsHandler(InvalidCredentialsException ex) {
        ExceptionModel error = new ExceptionModel(ex.getMessage(), ex.getStatus().value());
        return new ResponseEntity<>(error, ex.getStatus());
    }

}
