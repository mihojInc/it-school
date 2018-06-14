package com.lessons;

public enum Commands {
    ADD("To add number to array, print 'add'", "add"),
    SORT_TO_MAX("To watch numbers sorted from min to max, print 'sort to max'", "sort to max"),
    SORT_TO_MIN("To watch numbers sorted from max to min, print 'sort to min'", "sort to min"),
    CLEAR("To clear array, print 'clear'", "clear"),
    EXIT("To quit program, print 'exit'", "exit");

    private String message;
    private String command;

    Commands(String message, String command) {
        this.message = message;
        this.command = command;
    }

    public String getMessage() {
        return message;
    }

    public String getCommand() {
        return command;
    }
}
