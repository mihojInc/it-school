package com.lessons;

public enum Commands {
    ADD("To add number to array, print 'add' \n", "add"),
    SORT_TO_MAX("To watch numbers sorted from min to max, print 'sort to max' \n", "sort to max"),
    SORT_TO_MIN("To watch numbers sorted from max to min, print 'sort to min' \n", "sort to min"),
    CLEAR("To clear array, print 'clear' \n", "clear"),
    EXIT("To quit program, print 'exit' \n", "exit");

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
