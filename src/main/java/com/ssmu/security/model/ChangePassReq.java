package com.ssmu.security.model;

public class ChangePassReq {
    private String username;
    private String oldPassword;
    private String newPassword;
    private String email;
    private String secretKey;

    public ChangePassReq() {
    }

    public ChangePassReq(String username, String oldPassword, String newPassword, String email, String secretKey) {
        this.username = username;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.email = email;
        this.secretKey = secretKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "ChangePassReq [username=" + username + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword
                + ", email=" + email + ", secretKey=" + secretKey + "]";
    }

  
}
