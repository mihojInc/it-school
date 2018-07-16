package com.lessons;

public class Consumer implements Runnable {
    private String name;
    private Store store;
    private long choosingTime;

    public Consumer(String name, Store store, long choosingTime) {
        this.name = name;
        this.store = store;
        this.choosingTime = choosingTime;
    }

    @Override
    public void run() {
        while(store.getCounterC().intValue()>0){
            store.get(name);
        }



    }
}
