package com.psi.satrello.login.repository;

import com.psi.satrello.login.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserLoginRepository extends JpaRepository <UserLogin, UUID> {

    Optional<UserLogin> findByPersonalId(String personalId);

}
