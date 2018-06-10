package com.lessons;

public enum SortCommands {

    ADD_NUMBER("add"),
    SORT_DESCENDING("sort d"),
    SORT_ASCENDING("sort a"),
    CLEAR_LIST("clear"),
    QUIT("q");

    private String commandName;

    SortCommands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
