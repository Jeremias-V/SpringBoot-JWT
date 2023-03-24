package com.psi.satrello.login.service;

import com.psi.satrello.login.entity.User;
import com.psi.satrello.login.model.UserModel;

import java.util.List;

public interface UserService {

    public List<User> fetchUserList();

    User saveUser(UserModel userModel) throws Exception;
}
