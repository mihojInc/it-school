package com.lessons;

public class App {
    public static void main(String[] args) {

        Store store = new Store();
        Manufacturer manufacturer = new Manufacturer(new Product("Хлеб"), store);
        Manufacturer manufacturer2 = new Manufacturer(new Product("Молоко"), store);

        new Thread(manufacturer).start();
        new Thread(manufacturer2).start();


    }
}
