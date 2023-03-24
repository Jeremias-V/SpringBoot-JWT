package com.psi.satrello.login.controller;

import com.psi.satrello.login.entity.User;
import com.psi.satrello.login.model.UserModel;
import com.psi.satrello.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This Controller is only used for testing purposes.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This method is just for testing purposes.
     * @param userModel as JSON
     * @return User
     */
    @PostMapping("/add")
    public User saveUser(@RequestBody UserModel userModel) throws Exception {
        User user = userService.saveUser(userModel);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.fetchUserList();
    }

}
