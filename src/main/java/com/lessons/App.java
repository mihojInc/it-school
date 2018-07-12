package com.lessons;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class App {


    public static void main(String[] args) {
        AtomicInteger x = new AtomicInteger(0);
        AtomicReference<Thread> threadAtomicReference = new AtomicReference<>(new Thread());
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(x, String.valueOf(i)));
            t.setName("Thread " + i);
            t.start();
        }

    }
}


