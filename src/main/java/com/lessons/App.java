package com.lessons;

import static com.lessons.Production.*;

public class App {
    public static void main(String[] args) {
        Store store = new Store();
        Producer first = MILK.createProducer(store);
        Producer second = MEAT.createProducer(store);
        Producer third = FISH.createProducer(store);
        Consumer firstC = new Consumer("Andrey",store,500l );
        Consumer secondC = new Consumer("Ann",store,1500l );
        new Thread(first).start();
        new Thread(second).start();
        new Thread(third).start();
        new Thread(firstC).start();
        new Thread(secondC).start();



    }
}
