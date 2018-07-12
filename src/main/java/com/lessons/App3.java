package com.lessons;

public class App3 {
    public static void main(String[] args) {
        Resource2 commonResource= new Resource2();
        for (int i = 1; i < 6; i++){

            Thread t = new Thread(new CountThread3(commonResource));
            t.setName("Thread "+ i);
            t.start();
        }
    }
}

