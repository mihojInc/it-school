package com.lessons;

/**
 * This enum describes used commands in this program for working with the array of numbers: sort, clear, close program.
 */

public enum SortCommands {

    SORT_DESCENDING("d"),
    SORT_ASCENDING("a"),
    CLEAR_LIST("c"),
    QUIT("q");

    private String commandName;

    SortCommands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
