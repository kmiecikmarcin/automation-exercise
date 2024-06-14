package com.automationexercise.framework.helpers;

import java.util.Random;

public abstract class Generators {

    public static final String USER_NAME = "John";
    public static final String USER_PASSWORD = "password0@";

    public static String generateEmail() {
        Random random = new Random();
        return "test.email.test" + random.nextInt() + "@test.com";
    }
}
