package com.lessons;

public class Water implements Item {
    private String nameOfWater;
    private double priceOfWater;

    Water (String name, double price){
        this.nameOfWater = name;
        this.priceOfWater = price;
    }
    @Override
    public String getName() {
        return nameOfWater;
    }

    @Override
    public Double getPrice() {
        return priceOfWater;
    }
}
