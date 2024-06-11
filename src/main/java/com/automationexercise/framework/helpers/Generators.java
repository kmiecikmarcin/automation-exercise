package com.automationexercise.framework.helpers;

import java.util.Random;

public abstract class Generators {
    private Generators() {}

    public static String userName() {
        return "John";
    }

    public static String generateEmail() {
        Random random = new Random();
        return "test.email.test" + random.nextInt() + "@test.com";
    }
}
