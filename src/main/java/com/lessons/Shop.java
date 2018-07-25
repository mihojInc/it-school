package com.lessons;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Items> items = new ArrayList<>();
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public  synchronized void setItems(Items item) {
        while (items.size()>=6) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        items.add(item);
        System.out.println("Поставщик положил товар" + item.getName() + " Количество товара в магазине " + items.size() + " Всего товара " + count);
        count++;
        notify();
    }

    public synchronized void getItem(){
        while (items.size()<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        items.remove(items.size()-1);
        System.out.println("Покупатель купил товар" + " Количество товара в магазине " + items.size() + " Всего товара " + count);
        notify();

    }

    public int getSize(){
        return items.size();
    }
}
