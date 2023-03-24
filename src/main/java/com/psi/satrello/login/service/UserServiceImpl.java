package com.psi.satrello.login.service;

import com.psi.satrello.login.entity.User;
import com.psi.satrello.login.model.UserModel;
import com.psi.satrello.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(UserModel userModel) throws Exception {
        Optional<User> existingUser = userRepository.findByUsername(userModel.getUsername());
        if(existingUser.isPresent()){
            throw new Exception("Username already exists.");
        }else{
            User user = new User();
            user.setUserId(UUID.randomUUID());
            user.setUsername(userModel.getUsername());
            user.setPassword(passwordEncoder.encode(userModel.getPassword()));

            userRepository.save(user);
            return user;
        }

    }
}
