package com.psi.satrello.login.repository;

import com.psi.satrello.login.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAccountRepository extends JpaRepository <UserAccount, UUID> {

    Optional<UserAccount> findByPersonalId(String personalId);

}
