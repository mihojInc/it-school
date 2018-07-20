package com.lessons;

import static com.lessons.Production.*;

public class App {
    public static void main(String[] args) {
        FileWriter.clear();
        /*Store store = new Store();
        Producer first = MILK.createProducer(store);
        Producer second = MEAT.createProducer(store);
        Producer third = FISH.createProducer(store);
        Consumer firstC = new Consumer("Andrey",store,500l );
        Consumer secondC = new Consumer("Ann",store,1500l );
        new Thread(first).start();
        new Thread(second).start();
        new Thread(third).start();
        new Thread(firstC).start();
        new Thread(secondC).start();8*/
        Store_Version2 store_version2 = new Store_Version2();
        Producer_Version2 first = MILK.createProducer2(store_version2);
        Producer_Version2 second = MEAT.createProducer2(store_version2);
        Producer_Version2 third = FISH.createProducer2(store_version2);
        Consumer_Version2 firstC = new Consumer_Version2("Andrey",100l,store_version2  );
        Consumer_Version2 secondC = new Consumer_Version2("Ann",1500l,store_version2  );
        first.start();
        second.start();
        third.start();
        firstC.start();
        secondC.start();

        try {first.join();
            second.join();
            third.join();
            firstC.join();
            secondC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FileWriter.finalStat();



    }
}
