package com.lessons;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Shop {
    private ArrayList<Product> productList = new ArrayList<Product>();
    List<Product> productListSync = Collections.synchronizedList(productList);
    private volatile Integer  PRODUCT_COUNTER = 0;
    private volatile Integer  TOTAL_PRODUCTS = 0;

    public Integer getPRODUCT_COUNTER() {
        return PRODUCT_COUNTER;
    }

    public void setPRODUCT_COUNTER(Integer PRODUCT_COUNTER) {
        this.PRODUCT_COUNTER = PRODUCT_COUNTER;
    }

    public Integer getTOTAL_PRODUCTS() {
        return TOTAL_PRODUCTS;
    }

    public void setTOTAL_PRODUCTS(Integer TOTAL_PRODUCTS) {
        this.TOTAL_PRODUCTS = TOTAL_PRODUCTS;
    }

    //    private File file = new File("./src/main/java/com/lessons/report.txt");
//    private Producer producer;
//    private Customer customer;
//    private Integer boughtProduct =  (int) ( Math.random() * (productListSync.size()-1) );

    public List<Product> getProductListSync() {
        return productListSync;
    }

    public void setProductListSync(List<Product> productListSync) {
        this.productListSync = productListSync;
    }

//    public Integer getBoughtProduct() {
//        return boughtProduct;
//    }
//
//    public void setBoughtProduct(Integer boughtProduct) {
//        this.boughtProduct = boughtProduct;
//    }
}
