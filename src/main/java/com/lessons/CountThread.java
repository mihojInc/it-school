package com.lessons;

import java.util.concurrent.atomic.AtomicInteger;

public class CountThread implements Runnable {

    AtomicInteger res;
    String name;

    CountThread(AtomicInteger integer, String name) {
        this.res = integer;
        this.name=name;
    }

    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Thread name " + name + " " + res.get());
            res.getAndIncrement();
        }
    }
}
