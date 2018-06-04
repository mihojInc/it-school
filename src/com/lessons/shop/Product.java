package com.lessons.shop;

/**
 * some product for trading
 * may be abstract, but just one
 */
public class Product implements Item {

    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    public Product() {
    }

    //it so nether use, still..
    private String name = "no name";

    //it's to
    private double price = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
