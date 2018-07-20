package com.lessons;

public class Producer_Version2 extends Thread {

    private Store_Version2 store_version2;

    private String typeOfProducer;

    private long timeForProducing;

    public Producer_Version2(String name, long timeForProducing,Store_Version2 store_version2) {
        this.typeOfProducer = name;
        this.timeForProducing = timeForProducing;
        this.store_version2 = store_version2;
    }

    @Override
    public void run(){
            while(store_version2.getCounter()<40){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                createGoods();
            }
    }

    public void createGoods(){
        synchronized (store_version2){
        if(store_version2.getGoods().size()<6){
            String msg = "Producer of " + typeOfProducer + " added " + typeOfProducer;
            store_version2.put(typeOfProducer);
            store_version2.setCounter(store_version2.getCounter()+1);
            System.out.println("There are " + store_version2.getGoods().size() + " in the store!");
            System.out.println(msg);
            FileWriter.write(msg);
        }else {
            System.out.println("Warehouse is full!!!" ); }
        }
    }
}
