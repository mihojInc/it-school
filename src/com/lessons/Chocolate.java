package com.lessons;

/**
 * This class is a chocolate model that describes chocolate parameters and methods.
 */

public class Chocolate implements Item{
    private String name;
    private static final Double PRICE = 6d;

    Chocolate(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return PRICE;
    }
}
