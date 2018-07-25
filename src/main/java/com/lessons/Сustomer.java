package com.lessons;

public class Сustomer implements Runnable{
    private int timeRep = 1000;
    private String name;
    private Shop shop;
    static int count = 0;

    public Сustomer(String name, Shop shop, int timeRep) {
        this.name = name;
        this.shop = shop;
        this.timeRep = timeRep;
    }

    public String getName() {
        return name;
    }

    public int getTimeRep() {
        return timeRep;
    }

    @Override
    public void run() {
        while (true){
            if (!(Shop.getCount() == 41)){
                shop.getItem();
                try {
                    Thread.sleep(timeRep);
                }catch (InterruptedException e){

                }
            }else {
            break;
            }
        }
    }
}
