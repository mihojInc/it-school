package com.lessons.DownloadService;

public class EmptyURLException extends Exception {

    public EmptyURLException() {
        super();
    }

    public EmptyURLException(String message) {
        super(message);
    }
}
