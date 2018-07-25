package com.lessons;

public class Provider implements Runnable{
    private int timeRep = 1000;
    private String name;
    private Shop shop;
    private TypeItems t;

    public Provider(Shop shop, String name, TypeItems type, int timeRep) {
        this.name = name;
        this.shop = shop;
        this.t = type;
        this.timeRep = timeRep;
    }

    public String getName() {
        return name;
    }

    public int getTimeRep() {
        return timeRep;
    }

    @Override
    public void run(){
        while (true){
            if (!(Shop.getCount() >= 40)){
                shop.setItems(new Items(t.getName()));

                try {
                    Thread.sleep(timeRep);
                }catch (InterruptedException e){
                    System.out.println("1");
                }

            }else {
                break;
            }
        }
    }
}
