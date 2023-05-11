package com.psi.satrello.login.controller;

import com.psi.satrello.login.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RoleController {

    @Autowired
    private UserRoleService roleService;

    @GetMapping(value="/role/{personalId}")
    public ResponseEntity<Map<String, String>> getUserRole(
            @PathVariable("personalId") String personalId) {

        if (personalId.equals("")) {
            throw new RuntimeException("No parameter received in /role/?");
        }

        HashMap<String, String> json = new HashMap<>();
        json.put("role", roleService.getUserRole(personalId));

        return new ResponseEntity<>(json, HttpStatus.OK);
    }


}
