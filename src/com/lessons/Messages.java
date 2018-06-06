package com.lessons;

public enum Messages {
    ERROR ("You print incorrect data"),
    EXIT ("Program is finished");

    private String message;

    Messages(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
