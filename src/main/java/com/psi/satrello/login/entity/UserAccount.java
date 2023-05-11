package com.psi.satrello.login.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "user_account", schema = "account")
@Data
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "user_id", columnDefinition = "uuid", updatable = false)
    private UUID userId;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "personal_id")
    private String personalId;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "state_id")
    private Integer stateId;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "legal_guardian")
    private String guardianName;

}
