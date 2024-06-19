package com.automationexercise.framework.helpers;

public class UserData {

    protected String userName;
    protected String userEmail;
    private String userPassword;

    public UserData(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public UserData(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
