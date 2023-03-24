package com.psi.satrello.login.model;

import java.io.Serializable;

public record JwtResponseModel(String token) implements Serializable {

    private static final long serialVersionUID = 1L;

}
