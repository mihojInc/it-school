package com.lessons.util;

/**
 * Represent console commands from compare with user input
 */
public enum ConsoleCommand {
    Q("q"),
    R("r"),
    F("f");

    private String consoleIterpritate;

    ConsoleCommand(String consoleIterpritate) {
        this.consoleIterpritate = consoleIterpritate;
    }

    public String getConsoleInterpritate() {
        return consoleIterpritate;
    }
}
