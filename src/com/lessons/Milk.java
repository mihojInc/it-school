package com.lessons;

/**
 * This class is a milk model that describes milk parameters and methods.
 */

public class Milk implements Item {
    private String name;
    private Double price;
    private ItemType itemType;

    Milk() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String itemName) {
        this.name = itemName;
    }


    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public void setPrice(Double itemPrice) {
        this.price = itemPrice;
    }
    @Override
    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

}
