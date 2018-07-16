package com.lessons;

public class Producer implements Runnable {
    String name;
    long timeForProducing;
    Store store;

    public Producer(String name, long timeForProducing, Store store) {
        this.name = name;
        this.timeForProducing = timeForProducing;
        this.store = store;
    }

    @Override
    public void run() {
        while(store.getCounterP().intValue() <41){
            store.put(name);
        }


    }
}
