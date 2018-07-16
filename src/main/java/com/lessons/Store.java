package com.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Store {

    private AtomicInteger product= new AtomicInteger(0);
    private List<String> listOfProducts = new ArrayList<>();
    private CopyOnWriteArrayList<String> synchr = new CopyOnWriteArrayList<>(listOfProducts);
    private Random random = new Random();
    private AtomicInteger counterP = new AtomicInteger(0);
    private AtomicInteger counterC = new AtomicInteger(40);


    public void put(String name){
        String msg;
        while(product.intValue()>=6){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        product.getAndIncrement();
        counterP.getAndIncrement();
        synchr.add(name);
        //listOfProducts.add(name);
       synchronized (this){
        msg = "Произвоитель " + name + " добавил " + name;
        System.out.println(msg);
        FileWriter.write(msg);
        System.out.println("Товаров на складе" + product);}
    }

    public  void get(String name){
        String msg;
        while(product.intValue()<1){
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //int aRandomNumber = random.nextInt(listOfProducts.size());
        int aRandomNumber = random.nextInt(synchr.size());
        product.getAndDecrement();
        counterC.getAndDecrement();
        //String chosenProduct = listOfProducts.get(aRandomNumber);
        String chosenProduct = synchr.get(aRandomNumber);
        //listOfProducts.remove(aRandomNumber);
        synchr.remove(aRandomNumber);
        synchronized (this){
        msg = name + " купил " + chosenProduct;
        System.out.println(msg);
        FileWriter.write(msg);
        System.out.println("Товаров на складе: " + product);}
    }

    public AtomicInteger getCounterP() {
        return counterP;
    }

    public  AtomicInteger getCounterC() {
        return counterC;
    }
}
