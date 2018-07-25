package com.lessons;

public class App {
    public static void main(String[] args) {

        Shop store = new Shop();

        Provider provider1= new Provider(store, "ATB", TypeItems.FISH, 100);
        Provider provider2= new Provider(store, "ROST", TypeItems.MEET, 500);
        Provider provider3= new Provider(store, "KLASS", TypeItems.MILK, 900);

        Сustomer сustomer1 = new Сustomer("Vasya", store, 1200);
        Сustomer сustomer2 = new Сustomer("Petya", store, 300);


        new Thread(provider1).start();
        new Thread(provider2).start();
        new Thread(provider3).start();
        new Thread(сustomer1).start();
        new Thread(сustomer2).start();


    }
}
