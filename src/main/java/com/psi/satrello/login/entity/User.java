package com.psi.satrello.login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * User is a temporal entity, this should be mapped to a user model
 * with spring-data-jpa using the postgres-sql aws database.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;


    private String username;
    private String password;

}
