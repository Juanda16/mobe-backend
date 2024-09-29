package com.ssmu.security.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuthenticationReq implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "username", name = "username", example = "user", required = true, type = "string")
    private String username;

    @Schema(description = "password", name = "password", example = "userPassword", required = true, type = "string")
    private String password;

    public AuthenticationReq(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getuserName() {
        return username;
    }

    public void setuserName(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthenticationReq [username=" + username + ", password=" + password + "]";
    }
}
