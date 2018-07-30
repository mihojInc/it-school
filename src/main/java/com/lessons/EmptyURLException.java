package com.lessons;

public class EmptyURLException extends Exception {
    public EmptyURLException(){
        super("Sorry, but this URL is empty");
    }
}
