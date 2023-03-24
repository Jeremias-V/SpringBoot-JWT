package com.psi.satrello.login.service;

import com.psi.satrello.login.entity.User;
import com.psi.satrello.login.model.JwtUser;
import com.psi.satrello.login.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            JwtUser finalUser = new JwtUser(user.get().getUsername(), user.get().getPassword());
            return finalUser;
        } else {
            throw new UsernameNotFoundException(String.format("User with username '%s' not found.", username));
        }

    }
}
