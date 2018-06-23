package com.lessons;

/**
 * Created by Ivan
 */
public enum Commands {
    ADD_PLAYER("add"),
    UNIQUE_PLAYERS("unique"),
    SHOW_PLAYERS_BY_RATING("rating"),
    DELETE_PLAYER("delete"),
    SHOW_TEAMS_AND_PLAYERS("team"),
    PLAY_MATCH("play"),
    QUIT("q");

    private String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
