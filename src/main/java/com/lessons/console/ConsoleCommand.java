package com.lessons.console;

/**
 * Application control command
 */
public enum ConsoleCommand {
    Q("q", "quit"),
    DFF("df", "download all from file"),
    DFC("dc", "download for console input text"),
    H("h", "help");
    private String consoleInterpretate;
    private String discription;

    public String getConsoleInterpretate() {
        return consoleInterpretate;
    }

    public String getDiscription() {
        return discription;
    }

    ConsoleCommand(String consoleInterpretate, String discription) {
        this.consoleInterpretate = consoleInterpretate;
        this.discription = discription;
    }

    public ConsoleCommand getByInterpritate(String interpritate) {
        for(ConsoleCommand command : ConsoleCommand.values()) {
            if (interpritate.equals(command.getConsoleInterpretate())) {
                return command;
            }
        }
        return H;
    }

    /**
     * @return string command and their descriptions
     */
    public String getStringAbout() {
        StringBuilder returned = new StringBuilder();
        for (ConsoleCommand c : ConsoleCommand.values()) {
            returned.append(c.consoleInterpretate);
            returned.append(" - ");
            returned.append(c.discription);
            returned.append(", ");
        }
        returned.setLength(returned.length() - 2);//trim ends ','
        return returned.toString();
    }
}
