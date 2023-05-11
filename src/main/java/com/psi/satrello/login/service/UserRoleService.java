package com.psi.satrello.login.service;

import com.psi.satrello.login.entity.UserAccount;
import com.psi.satrello.login.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    UserAccountRepository accountRepository;

    public String getUserRole(String personalId) {

        Optional<String> optRole = accountRepository.getRoleNameByPersonalId(personalId);

        if (optRole.isPresent()) {
            return optRole.get();
        } else {
            throw new RuntimeException("No role found associated to personalId = " + personalId);
        }

    }

}
