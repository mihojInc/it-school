package com.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {

    private int product=0;
    private List<String> listOfProducts = new ArrayList<>();
    private Random random = new Random();
    private AtomicInteger counterP = new AtomicInteger(0);
    private AtomicInteger counterC = new AtomicInteger(40);


    public synchronized void put(String name){
        String msg;
        while(product>=6){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        counterP.getAndIncrement();
        listOfProducts.add(name);
        msg = "Произвоитель " + name + " добавил " + name;
        System.out.println(msg);
        FileWriter.write(msg);
        System.out.println("Товаров на складе" + product);
        notify();
    }

    public synchronized void get(String name){
        String msg;
        while(product<1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int aRandomNumber = random.nextInt(listOfProducts.size());
        product--;
        counterC.getAndDecrement();
        String chosenProduct = listOfProducts.get(aRandomNumber);
        listOfProducts.remove(aRandomNumber);
        msg = name + " купил " + chosenProduct;
        System.out.println(msg);
        FileWriter.write(msg);
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public AtomicInteger getCounterP() {
        return counterP;
    }

    public  AtomicInteger getCounterC() {
        return counterC;
    }
}
