package main.java.com.lessons;

/**
 * Represent the console command and descriptor by introduced value
 */
public enum ConsoleCommand {
    N0_COMMAND(null, "no command"),
    H("h", "get help"),
    A("a", "add new player"),
    V("v", "view all players"),
    VS("V", "view all players by skill"),
    P("p", "play football match"),
    D("d", "delete player"),
    Q("q", "quit");

    /**
     * Console representation
     */
    private String value;

    /**
     * Some information about this command
     */
    private String description;

    ConsoleCommand(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Convert string value to his ConsoleCommand issue
     *
     * @return enum by parsing sting value of NO_COMMAND if it d't exist
     */
    public ConsoleCommand parse(String value) {
        for (ConsoleCommand c : values())
            if (c.getValue() != null && c.getValue().equals(value))
                return c;
        return N0_COMMAND;
    }
}
