package com.lessons;

/**
 * this enum describe list of conmmands
 */
public enum Commands {
    ADD("Add to Array", 0),
    SORT_BUB_ACS("Bubble Sort Aray by ascending", 1),
    SORT_BUB_DESC("Bubble sort Aray by descending", 2),
    SORT_INS_ACS("Incert Sort Aray by ascending", 3),
    SORT_INS_DESC("Incert sort Aray by descending", 4),
    CLEAR("Clear Array", 5),
    QUIT("Quit", 6);
    /**
     * Describe command in common
     */
    private String DescribeComman;
    /**
     * Save position of command in enum
     */
    private int pos;

    public int getPos() {
        return pos;
    }

    public String getDescribeComman() {
        return DescribeComman;
    }

    Commands(String describeComman, int pos) {
        DescribeComman = describeComman;
        this.pos = pos;
    }
}
