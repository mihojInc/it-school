package com.lessons;

public class Sausage implements Item {
    private String nameOfSausage;
    private double priceOfSausage;

    Sausage (String name, double price){
        this.nameOfSausage = name;
        this.priceOfSausage = price;
    }
    @Override
    public String getName() {
        return nameOfSausage;
    }

    @Override
    public Double getPrice() {
        return priceOfSausage;
    }
}
