package com.psi.satrello.login.service;

import com.psi.satrello.login.entity.UserLogin;
import com.psi.satrello.login.error.InvalidCredentialsException;
import com.psi.satrello.login.model.JwtUser;
import com.psi.satrello.login.repository.UserLoginRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String personalId) {

        Optional<UserLogin> loginDetails = userLoginRepository.findByPersonalId(personalId);
        String userPassword = null;

        if (loginDetails.isPresent()) {

            userPassword = loginDetails.get().getPassword();
            JwtUser finalUser = new JwtUser(personalId, userPassword);
            return finalUser;

        } else {
            throw new InvalidCredentialsException("Invalid username or password.");
        }
    }
}
