package com.lessons;
/*
This enum cotteins list of players
 */
public enum Players {
    COMPUTER ("Computer", "0"),
    PLAYER("Player", "x");
    /**
     * name player
     */
    private String rusName;
    /**
     * step players
     */
    private String mark;

    Players(String rusName, String mark) {
        this.rusName = rusName;
        this.mark = mark;
    }

    public String getRusName() {
        return this.rusName;
    }

    public String getMark() {
        return this.mark;
    }
}
