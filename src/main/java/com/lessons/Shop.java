package com.lessons;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Shop {
    private ArrayList<Product> productList;
    private List<Product> productListSync = Collections.synchronizedList(productList);

    private File file = new File("./src/main/java/com/lessons/report.txt");
    private Producer producer;
    private Customer customer;
    private Integer boughtProduct =  (int) ( Math.random() * productListSync.size() );

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
        String str = "Customer " + customer.getName() + " bought " + boughtProduct;
        System.out.println(str);
        FileService.appedToFile(file, str);
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
        String str = "Producer of " + producer.getProduct().getName() + " add one good to shop";
        System.out.println(str);
        FileService.appedToFile(file, str);
        notify();
    }
}
