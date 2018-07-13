package com.lessons;

public class Producer {
    Product product;

    public Producer(String productName) {
        this.product = new Product(productName);
    }

    public Product getProduct() {
        return product;
    }

}
