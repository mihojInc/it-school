package com.lessons;

/**
 * Created by Ivan
 * enum commands
 */
public enum Commands {
    SORT_DECREASING("decr"),
    SORT_ASCENDING("asc"),
    CLEAR_LIST("clear"),
    QUIT("q");

    private String commandName;

    Commands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
