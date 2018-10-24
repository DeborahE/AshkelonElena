package com.telRan.mish.model;

public class NotRegisteredUser {
    private  String myEmail;
    private  String password;
    private  String passwordRep;

    public NotRegisteredUser setMyEmail(String myEmail) {
        this.myEmail = myEmail;
        return this;
    }

    public NotRegisteredUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public NotRegisteredUser setPasswordRep(String passwordRep) {
        this.passwordRep = passwordRep;
        return this;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRep() {
        return passwordRep;
    }
}
