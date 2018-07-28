package com.lessons;

public class App {
    public static void main(String[] args) {

         FileWork.clear();
        MathAlgorithm fib = ProxyEx.getInstance(new Fibonachi());
        fib.dolphin();
    }
}
