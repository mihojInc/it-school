package com.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {

    private List<Product> productList = new ArrayList();
    private int COUNTER = 0;
    private volatile int MAX_SIZE_PRODUCT = 0;
    AtomicInteger atomicInteger = new AtomicInteger(MAX_SIZE_PRODUCT);

    //Getters and Setters
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getCOUNTER() {
        return COUNTER;
    }

    public void setCOUNTER(int COUNTER) {
        this.COUNTER = COUNTER;
    }

    public int getMAX_SIZE_PRODUCT() { return MAX_SIZE_PRODUCT; }

    public void setMAX_SIZE_PRODUCT(int MAX_SIZE_PRODUCT) {
        this.MAX_SIZE_PRODUCT = MAX_SIZE_PRODUCT;
    }

}
