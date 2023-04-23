package com.psi.satrello.login.controller;

import com.psi.satrello.login.security.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthorizationController {

    @Autowired
    private TokenManager tokenManager;

    @GetMapping(value = "/authorization", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> authorizationFunction(@RequestHeader("Authorization") String bearerToken){
        final String token = bearerToken.substring(7);
        HashMap<String, String> json = new HashMap<>();
        json.put("personal_id", tokenManager.getUserNameFromToken(token));
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}
