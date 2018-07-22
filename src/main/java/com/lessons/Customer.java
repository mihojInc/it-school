package com.lessons;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Runnable {

    private String name;
    private Store store;
    private List<Product> basket = new ArrayList<>();

    public Customer(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (store.atomicInteger.get() < 40) {
            try {
                Thread.sleep(0L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (store) {
                if (store.getCOUNTER() > 0) {
                    buyProduct();
                }
            }
        }
    }

    public void buyProduct() {
        if (store.getCOUNTER() > 0) {
            List<Product> storeProduct = store.getProductList();
            int randomProduct = (int) Math.random() * storeProduct.size();
//            if (randomProduct == storeProduct.size()) {
//                randomProduct--;
//            }
            Product buyingProduct = storeProduct.get(randomProduct);
            String text = "Buyer: " + getName() + " bought the goods: " + buyingProduct.getName();
            System.out.println(text);
            basket.add(buyingProduct);
            storeProduct.remove(randomProduct);
            store.setCOUNTER(store.getCOUNTER() - 1);
            store.setMAX_SIZE_PRODUCT(store.getMAX_SIZE_PRODUCT() - 1);
            FileManager.recordFile(text);
        }
    }
}
