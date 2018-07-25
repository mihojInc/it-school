package com.lessons;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Items> items = new ArrayList<>();
    private static int count = 0;
    WriteFile writer;

    public Shop(WriteFile writer) {
        this.writer = writer;
    }

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
        String text = "Поставщик положил товар" + item.getName() + " Количество товара в магазине " + items.size() + " Всего товара " + count;
        System.out.println(text);
        writer.writeFile(text);
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

        String text = "Покупатель купил товар" + " Количество товара в магазине " + items.size() + " Всего товара " + count;
        System.out.println(text);
        writer.writeFile(text);
        notify();

    }

    public int getSize(){
        return items.size();
    }
}
