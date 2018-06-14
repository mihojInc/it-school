package com.lessons;

public enum Messages {
    ERROR ("incorrect data\n");
    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
