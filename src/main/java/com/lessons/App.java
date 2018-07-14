package com.lessons;

import java.io.File;

public class App {
    public static void main(String[] args) {
        File file = new File("./src/main/java/com/lessons/report.txt");

        Shop shop = new Shop();

        Customer customer1 = new Customer("Tom", shop);
        Customer customer2 = new Customer("Nick", shop);

        Producer producer1 = new Producer("fish", shop);
        Producer producer2 = new Producer("meat", shop);
        Producer producer3 = new Producer("milk", shop);

        FileService.clearFile(file);

        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();

        new Thread(customer1).start();
        new Thread(customer2).start();

    }
}
