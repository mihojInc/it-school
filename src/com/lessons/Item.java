package com.lessons;

import java.util.Scanner;

public interface Item {
    /**
     * This method returns name of good.
     * @return String
     */
    String getName();
    void setName(String itemName);

    /**
     * This method returns price of good.
     * @return Double
     */
    Double getPrice();
    void setPrice(Double itemPrice);

    ItemType getItemType();
    void setItemType(ItemType itemType);
}
