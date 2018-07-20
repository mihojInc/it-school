package com.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Store_Version2 {

    private List<String> goods;

    public  int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter2() {
        return counter2;
    }

    public void setCounter2(int counter2) {
        this.counter2 = counter2;
    }

    private volatile int counter;

    private volatile int counter2;


    public Store_Version2(){
        goods = new ArrayList<>();
        counter = 1;
        counter2 = 1;
    }

    public void get(String item){
        goods.remove(item);
    }

    public void put(String item){
        goods.add(item);
    }

    /**
     *
     * @return current list of products
     */

    public List<String> getGoods() {
        return goods;
    }


}
