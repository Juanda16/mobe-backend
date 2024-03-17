package com.ssmu.security.model;

import java.io.Serializable;

public class AuthenticationReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

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
