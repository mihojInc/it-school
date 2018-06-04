package com.lessons.shop.gods;

import com.lessons.shop.Item;

/**
 * paper for printer item files create directly from initiate
 */
public class PaperForPrinter implements Item {

    private String name = "Paper";
    private double price = 35.80;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
