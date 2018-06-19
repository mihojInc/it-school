
public enum Command {

    LIST_PLAYERS ("1. Print list of players", 1),
    LEADERS_PLAYERS ("2. Print lead players", 1),
    ADD_PLAYER ("Add player",1),
    ADD_TEAM ("Add team",1),
    DELETE_PLAYER ("3. Delete player", 1),
    CHANGE_TEAM ("4. Change player team", 1),
    LIST_TEAM ("5. Print list of team", 1),
    LIST_TEAM_LEAD ("6. Print leaders of team", 1),
    PLAY_GAME ("7. Play game", 1),
    ADD_COUNTRY ("8. Add country", 1);

    String comm;
    int level;

    Command(String comm, int level) {
        this.comm = comm;
        this.level = level;
    }
}