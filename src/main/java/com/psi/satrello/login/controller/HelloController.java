package com.psi.satrello.login.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> helloWorld(){
        HashMap<String, String> json = new HashMap<>();
        json.put("message", welcomeMessage);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}
