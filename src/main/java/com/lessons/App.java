package com.lessons;

public class App {
    public static void main(String[] args) {

        Store store = new Store();

        Thread manufacturer1 = new Manufacturer(new Product("Хлеб"),store);
        Thread manufacturer2 = new Manufacturer(new Product("Молоко"),store);
        Thread manufacturer3 = new Manufacturer(new Product("Колбаса"),store);

        Thread customer1 = new Thread(new Customer("Коля", store));
        Thread customer2 = new Thread(new Customer("Вася", store));

        manufacturer1.start();
        manufacturer2.start();
        manufacturer3.start();

        customer1.start();
        customer2.start();

    }
}
