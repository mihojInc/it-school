package com.lessons;

import java.io.File;

public class Producer implements Runnable{
    private Product product;
    private Shop shop;
    private File file = new File("./src/main/java/com/lessons/report.txt");

    public Producer(String productName, Shop shop) {
        this.product = new Product(productName);
        this.shop = shop;
    }

    public Producer(Product product, Shop shop) {
        this.product = product;
        this.shop = shop;
    }

    public Product getProduct() {
        return product;
    }


    public void putProduct(Product product){
        synchronized (shop){
            while (shop.getPRODUCT_COUNTER() >= 6){
                try {
                    String strWait = "Producer of " + product.getName() + " is waiting for free space at stock";
                    FileService.appedToFile(file, strWait);
                    System.out.println(strWait);
                    shop.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String str = "Producer of " + product.getName() + " add one good to shop";

            shop.getProductListSync().add(product);
            shop.setPRODUCT_COUNTER(shop.getPRODUCT_COUNTER() + 1);
            shop.TOTAL_PRODUCTS.getAndIncrement();
            System.out.println(str);
            FileService.appedToFile(file, str);
            shop.notifyAll();
        }
    }

    public void run() {
        while(shop.TOTAL_PRODUCTS.get() < 41) {
            putProduct(product);
        }
    }


}
