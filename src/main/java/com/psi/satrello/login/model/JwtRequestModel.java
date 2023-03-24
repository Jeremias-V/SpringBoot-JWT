package com.psi.satrello.login.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ToString
public class JwtRequestModel implements Serializable {

    private static final long SerialVersionUID = 2636936156391265891L;
    private String username;
    private String password;

}
