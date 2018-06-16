package com.lessons;

public enum Commands {
    ADD_PLAYER("- To add new player, print 'add'","add"),
    UNIQUE_PLAYERS("- To see unique players, print 'unique","unique"),
    RATING_PLAYERS("- To see players' rating, print 'rating'","rating"),
    DELETE_PLAYER("- To delete player, print 'delete'","delete"),
    SHOW_TEAM_AND_PLAYERS("- To show teams and players","team"),
    PLAY_MATCH("- To play match, print 'play'","play"),
    EXIT("- To finish program, print 'exit'","exit");

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
