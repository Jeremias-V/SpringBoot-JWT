package com.psi.satrello.login.controller;

import com.psi.satrello.login.error.InvalidCredentialsException;
import com.psi.satrello.login.model.JwtRequestModel;
import com.psi.satrello.login.model.JwtResponseModel;
import com.psi.satrello.login.security.TokenManager;
import com.psi.satrello.login.service.JwtUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class JwtController {

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenManager tokenManager;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseModel> createToken(@RequestBody JwtRequestModel request) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getPersonalId(),
                            request.getPassword())
            );
        } catch (DisabledException ex) {
            log.error(ex.getMessage());
            throw new Exception("USER_DISABLED", ex);
        } catch (BadCredentialsException ex) {
            log.error(ex.getMessage());
            throw new InvalidCredentialsException("Invalid username or password.");
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getPersonalId());
        final String jwtToken = tokenManager.generateJwtToken(userDetails);
        log.info("User " + request.getPersonalId() + " logged in.");
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));
    }

}
