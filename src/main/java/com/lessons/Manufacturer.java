package com.lessons;

public class Manufacturer extends Thread {

    private Product product;
    private Store store;

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
        while (store.getMAX_SIZE_PRODUCT() < 40) {
            try {
                sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (store) {
                makeProduct();
            }
        }
    }

    /**
     * The method in which a new product is manufactured
     */
    public void makeProduct() {
        if (store.getCOUNTER() < 6) {
            String text = "Manufacturer: " + product.getName() + " added 1 product to the store.";
            store.getProductList().add(product);
            store.setCOUNTER(store.getCOUNTER() + 1);
            System.out.println("Products in stock: " + store.getCOUNTER());
            System.out.println(text);
            FileManager.recordFile(text);
        }
    }
}
