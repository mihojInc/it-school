package com.lessons;

public class App {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci("FIBONACCI METHOD!");
        MultiThread multiThread = new MultiThread("MULTI METHOD!");
        Exponentiation exponentiation = new Exponentiation("EXPONENT METHOD!");

        System.out.println(fibonacci.getNameFib());
        fibonacci.start();
        System.out.println(multiThread.getNameMulti());
        multiThread.start();

        try {
            fibonacci.join();
            multiThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(exponentiation.getNameExponent());
        exponentiation.start();
    }
}
