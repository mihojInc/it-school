package com.lessons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Shop {
    ArrayList<Product> productList;
    List<Product> productListSync = Collections.synchronizedList(productList);

    Producer producer;
    Customer customer;
    Integer boughtProduct =  (int) ( Math.random() * productListSync.size() );

    public synchronized void getProduct(){
        while (productListSync.size() < 1){
            try {
                System.out.println("Customer " + customer.getName() + " waits");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productListSync.remove(1);
        System.out.println("Customer " + customer.getName() + " bought " + boughtProduct);
        notify();
    }

    public synchronized void putProduct(Producer producer){
        while (productListSync.size() >= 6){
            try {
                System.out.println("Producer of " + producer.getProduct().getName() + " is waiting for free space at stock");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productListSync.add(producer.getProduct());
        System.out.println("Producer of " + producer.getProduct().getName() + " add one good to shop");
        notify();
    }
}
