package com.util.tttFiles;

/**
 * Represent one field with his status
 */
public enum Field {
    ZERO("__|", "0_|", "x_|", StatementsField.EMPTY),
    ONE("__|", "0_|", "x_|", StatementsField.EMPTY),
    TWO("__", "0_", "x_", StatementsField.EMPTY),
    THREE("__|", "0_|", "x_|", StatementsField.EMPTY),
    FOUR("__|", "0_|", "x_|", StatementsField.EMPTY),
    FIVE("__", "0_", "x_", StatementsField.EMPTY),
    SIX("  |", "0 |", "x |", StatementsField.EMPTY),
    SEVEN("  |", "0 |", "x |", StatementsField.EMPTY),
    EIGTH("   ", "0  ", "x  ", StatementsField.EMPTY);

    private String emptyField, fieldO, fieldX;
    private StatementsField statementsField;

    Field(String emptyField, String fieldO, String fieldX, StatementsField statementsField) {
        this.emptyField = emptyField;
        this.fieldO = fieldO;
        this.fieldX = fieldX;
        this.statementsField = statementsField;
    }

    public String getEmptyField() {
        return emptyField;
    }

    public String getFieldO() {
        return fieldO;
    }

    public String getFieldX() {
        return fieldX;
    }

    public void setStatementsField(StatementsField statementsField) {
        this.statementsField = statementsField;
    }

    public StatementsField getStatementsField() {
        return statementsField;
    }

    /**
     * return string represent of lield by his statement
     */
    public String getFildByStatement() {
        switch (statementsField) {
            case EMPTY:
                return emptyField;
            case WITH0:
                return fieldO;
            case WITHX:
                return fieldX;
        }
        return null;
    }

}
