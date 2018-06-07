package com.lessons;

/**
 * Create enum Store Commands
 */
public enum StoreCommands {
    BUY_ITEM("B"),
    SELL_ITEM("S"),
    NEW_ITEM("N"),
    QUIT("Q");

    private String commandName;

    StoreCommands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
