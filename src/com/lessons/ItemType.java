package com.lessons;

public enum ItemType {
    MILK(1),
    CHOCOLATE(2),
    BREAD(3);

    private int itemName;

    ItemType(int itemName) {
        this.itemName = itemName;
    }

    public int getItemName(){
        return itemName;
    }

    public void setItemName(int itemName) {
        this.itemName = itemName;
    }
}


