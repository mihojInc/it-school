package com.lessons;

import java.io.File;

public class Customer implements Runnable{
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
                    String strWait = "Customer " + name + " waits";
                    FileService.appedToFile(file, strWait);
                    System.out.println(strWait);
                    shop.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Integer bought = (int) ( Math.random() * shop.getPRODUCT_COUNTER() );
            Product boughtProduct = shop.getProductListSync().get(bought);
            shop.setPRODUCT_COUNTER(shop.getPRODUCT_COUNTER() - 1);
            String str = "Customer " + name + " bought " + boughtProduct.getName();

            shop.getProductListSync().remove(boughtProduct);
            System.out.println(str);
            FileService.appedToFile(file, str);
            shop.notifyAll();
        }

    }

    public void run() {
        while(shop.TOTAL_PRODUCTS.get() < 41) {
            getProduct();
        }
    }

}
