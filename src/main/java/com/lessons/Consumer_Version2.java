package com.lessons;

import java.util.List;
import java.util.Random;

public class Consumer_Version2 extends Thread {

    private Store_Version2 store_version2;

    private String name;

    private Store store;

    private long choosingTime;

    public Consumer_Version2(String name, long choosingTime, Store_Version2 store_version2) {
        this.name = name;
        this.choosingTime = choosingTime;
        this.store_version2 = store_version2;
    }

    @Override
    public void run(){
            while(store_version2.getCounter2()<40){
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                  buy();
            }
    }

    public void buy(){
        synchronized (store_version2) {
            if (store_version2.getGoods().size() > 0) {
                List<String> shopList = store_version2.getGoods();
                Random random = new Random();
                int randomNumber = random.nextInt(store_version2.getGoods().size());
                String msg = name + " buy " + shopList.get(randomNumber);
                store_version2.get(shopList.get(randomNumber));
                store_version2.setCounter2(store_version2.getCounter2() + 1);
                System.out.println("There are " + store_version2.getGoods().size() + " in the store!");
                System.out.println(msg);
                FileWriter.write(msg);
            }else {
                System.out.println("Warehouse is empty!!!" );}
        }
    }
}
