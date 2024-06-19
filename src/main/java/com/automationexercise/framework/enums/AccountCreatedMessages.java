package com.automationexercise.framework.enums;

public enum AccountCreatedMessages {
    ACCOUNT_CREATED("ACCOUNT CREATED!"),
    CONGRATULATIONS("Congratulations! Your new account has been successfully created!"),
    DESCRIPTION("You can now take advantage of member privileges to "
            + "enhance your online shopping experience with us.");

    private final String message;

    AccountCreatedMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
