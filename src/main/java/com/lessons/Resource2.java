package com.lessons;

public class Resource2 {

    int x = 0;

    Object lock = new Object();

    void increment() {
        synchronized (lock) {
            x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
                x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
