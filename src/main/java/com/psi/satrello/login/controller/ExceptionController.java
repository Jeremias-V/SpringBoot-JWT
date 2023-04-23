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

    @ExceptionHandler(value = TokenExpiredException.class)
    public ResponseEntity<ExceptionModel> tokenExpiredHandler(TokenExpiredException ex) {
        ExceptionModel error = new ExceptionModel(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = InvalidTokenException.class)
    public ResponseEntity<ExceptionModel> invalidTokenHandler(InvalidTokenException ex) {
        ExceptionModel error = new ExceptionModel(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = InvalidCredentialsException.class)
    public ResponseEntity<ExceptionModel> invalidCredentialsHandler(InvalidCredentialsException ex) {
        ExceptionModel error = new ExceptionModel(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

}
