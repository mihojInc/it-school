package com.lessons;

public class App2 {
    public static void main(String[] args) {
        Resource commonResource= new Resource();
        for (int i = 1; i < 6; i++){
            Thread t = new Thread(new CountThread2(commonResource));
            t.setName("Thread "+ i);
            t.start();
        }
    }
}

