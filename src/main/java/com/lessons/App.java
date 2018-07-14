package com.lessons;

import java.io.File;

public class App {
    public static void main(String[] args) {
        File file = new File("./src/main/java/com/lessons/report.txt");

        Shop shop = new Shop();

//        Product fish = new Product("fish");
//        Product meat = new Product("meat");
//        Product milk = new Product("milk");

        Customer customer1 = new Customer("Tom", shop);
        Customer customer2 = new Customer("Nick", shop);

        Producer producer1 = new Producer("fish", shop);
        Producer producer2 = new Producer("meat", shop);
        Producer producer3 = new Producer("milk", shop);

        FileService.clearFile(file);
        ProducerRun producerRun1 = new ProducerRun(producer1);
        ProducerRun producerRun2 = new ProducerRun(producer2);
        ProducerRun producerRun3 = new ProducerRun(producer3);

        CustomerRun customerRun1 = new CustomerRun(customer1);
        CustomerRun customerRun2 = new CustomerRun(customer2);


        new Thread(producerRun1).start();
        new Thread(producerRun2).start();
        new Thread(producerRun3).start();

        new Thread(customerRun1).start();
        new Thread(customerRun2).start();

    }
}
