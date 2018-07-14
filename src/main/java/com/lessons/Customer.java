package com.lessons;

import java.io.File;

public class Customer{
    String name;
    Shop shop;
    private File file = new File("./src/main/java/com/lessons/report.txt");


    public Customer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getProduct(){
        synchronized (shop){
            while (shop.getPRODUCT_COUNTER() < 1){
                try {
                    System.out.println("Customer " + name + " waits");
                    shop.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Integer bought = (int) ( Math.random() * shop.getPRODUCT_COUNTER() );
            Product boughtProduct = shop.getProductListSync().get(bought);
            shop.setPRODUCT_COUNTER(shop.getPRODUCT_COUNTER() - 1);;
            shop.getProductListSync().remove(boughtProduct);
            String str = "Customer " + name + " bought " + boughtProduct.getName();
            System.out.println(str);
            FileService.appedToFile(file, str);
            shop.notifyAll();
        }

    }


}
