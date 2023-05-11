package com.psi.satrello.login.repository;

import com.psi.satrello.login.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserAccountRepository extends JpaRepository<UserAccount, UUID> {

    @Query("SELECT ur.name FROM UserAccount ua INNER JOIN UserRole ur ON ur.roleId = ua.roleId WHERE ua.personalId = ?1")
    Optional<String> getRoleNameByPersonalId(String personalId);

}
