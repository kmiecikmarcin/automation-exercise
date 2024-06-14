package com.automationexercise.framework.helpers;

public class UserData {

    public String userName;
    public String userEmail;
    public String userPassword;

    public UserData(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public UserData(String userPassword) {
        this.userPassword = userPassword;
    }
}
