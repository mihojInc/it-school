package com.util.tttFiles;

/**
 * Represent value of field
 */
public enum StatementsField {
    EMPTY(0),
    WITH0(-1),
    WITHX(1);

    private int value;

    StatementsField(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
