package com.lessons;

public enum ShopCommands {
    BUY_ITEM ("b"),
    SELL_ITEM ("s"),
    NEW_ITEM ("n"),
    QUIT("q");

    private String commandName;

    ShopCommands(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }
}
