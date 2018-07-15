package com.lessons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Manufacturer extends Thread{

    private Product product;
    private Store store;
    private File file = new File("/home/denis/Programming/it-school/src/main/java/com/lessons/FileProduct");

    //Constructor
    public Manufacturer(Product product, Store store) {
        this.product = product;
        this.store = store;
    }

    //Getters and Setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (store.getMAX_SIZE_PRODUCT() >= 40) {
            makeProduct();
        }
    }

    /**
     * The method in which a new product is manufactured
     */
    public synchronized void makeProduct() {
        while (store.getCOUNTER() > 6) {
            String string = "Производитель " + product.getName() + " добавил 1 товар в магазин";
            store.getProductList().add(product);
            store.setCOUNTER(store.getCOUNTER() + 1);
            System.out.println("Товаров на складе " + product);
            System.out.println(string);
            recordFile(this.file, string);
        }
    }

    /**
     * Method for writing text to a file
     * @param file - Original file
     * @param text - Some text
     */
    public void recordFile(File file, String text) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            if(file.exists()) {
                bufferedWriter.write(text + "\n");
                bufferedWriter.flush();
            } else {
                System.out.println("The recording didn't work!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
