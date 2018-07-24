package com.lessons;

public class EmptyURLException extends Exception{
    String message;

    @Override
    public String getMessage() {
        return "You print incorrect link";
    }
}
