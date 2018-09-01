package com.lessons.Common;

public enum Colors {
    WHITE("White", 0),
    BLACK("Black", 1),
    EMPTY("Empty", 2),
    NULL("Null", 3);

    private String desc;
    private int index;

    Colors(String desc, int index) {
        this.desc = desc;
        this.index = index;
    }

    public Colors setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Colors setIndex(int index) {
        this.index = index;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public int getIndex() {
        return index;
    }
}
