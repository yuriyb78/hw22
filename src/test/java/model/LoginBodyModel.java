package model;

public class LoginBodyModel {

    String UserName, password;

    public void setUserName(String email) {
        this.UserName = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return password;
    }
}
