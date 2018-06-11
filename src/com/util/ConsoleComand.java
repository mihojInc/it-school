package com.util;

/**
 * Represent console commands from compare with user input
 */
public enum ConsoleComand {
    Q("q");

    private String consoleIterpritate;

    ConsoleComand(String consoleIterpritate) {
        this.consoleIterpritate = consoleIterpritate;
    }

    public String getConsoleIterpritate() {
        return consoleIterpritate;
    }
}
