package com.psi.satrello.login.service;

import com.psi.satrello.login.entity.UserAccount;
import com.psi.satrello.login.entity.UserLogin;
import com.psi.satrello.login.model.JwtUser;
import com.psi.satrello.login.repository.UserAccountRepository;
import com.psi.satrello.login.repository.UserLoginRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserLoginRepository userLoginRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String personalId) {
        Optional<UserAccount> userDetails = userAccountRepository.findByPersonalId(personalId);
        UUID userId = null;
        String userPassword = null;

        if (userDetails.isPresent()) {

            userId = userDetails.get().getUserId();
            Optional<UserLogin> loginDetails = userLoginRepository.findByUserId(userId);

            if (loginDetails.isPresent()) {
                userPassword = loginDetails.get().getPassword();
            } else {
                throw new Exception(String.format("User with personal_id '%s' not found.", personalId));
            }
            JwtUser finalUser = new JwtUser(personalId, userPassword);
            return finalUser;
        } else {
            throw new Exception(String.format("User with personal_id '%s' not found.", personalId));
        }

    }
}
