package com.lessons;

/**
 * Class describe list of commands in menu
 */
public enum Command {

    LIST_PLAYERS("1. Print list of players", 1),//
    LEADERS_PLAYERS("2. Print lead players", 2),
    ADD_PLAYER("3. Add player", 3),//
    ADD_TEAM("4. Add team", 4),//
    DELETE_PLAYER("5. Delete player", 5),//
    CHANGE_TEAM("6. Change player team", 6),//
    LIST_TEAM("7. Print list of team", 7),//
    LIST_TEAM_LEAD("8. Print leaders of team", 8),
    PLAY_GAME("9. Play game", 9),
    EXIT("10. Exit", 10);
    /**
     * describe command
     */
    String comm;
    /**
     * number of command
     */
    int level;

    Command(String comm, int level) {
        this.comm = comm;
        this.level = level;
    }

    public String getComm() {
        return comm;
    }

    public int getLevel() {
        return level;
    }

}