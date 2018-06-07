package com.lessons;

/**
 * Create enum Goods Type
 */
public enum GoodsType {
    BOOK(1),
    NEWSPAPER(2),
    MAGAZINES(3);
    //Fields
    private Integer valueName;

    GoodsType(Integer valueName) {
        this.valueName = valueName;
    }
    //Constructor
    public Integer getValueName() {
        return valueName;
    }

    public void setValueName(Integer valueName) {
        this.valueName = valueName;
    }
}
