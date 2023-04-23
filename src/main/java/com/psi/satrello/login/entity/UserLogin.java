package com.psi.satrello.login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "login", name = "user_login")
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "login_id")
    private UUID userId;

    @Column(name = "personal_id")
    private String personalId;

    @Column(name = "password")
    private String password;

}
