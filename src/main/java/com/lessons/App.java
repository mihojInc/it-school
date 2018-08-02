package com.lessons;

public class App {
    public static void main(String[] args) throws NoSuchMethodException {
        MyFibonacci fibonacci = MyProxy.getInstance(new Fibonacci());
        fibonacci.printFibonacciNumber();
    }
}
