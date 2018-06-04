package com.lessons.shop;

/**
 * Some product for trading,
 * may be abstract, but just one
 */
public class Product implements Item {

    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    public Product() {
    }

    private String name;
    private double price;

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
