package com.lessons;
@Description
public class Fibonacci implements MyFibonacci {

    @Override
    @For(count = 20)
    public void printFibonacciNumber() {
        int a = 1, b = 1;
        int value = 0;
        while (a <= value) {
            System.out.print(a + " ");
            b = b + a;
            a = b - a;
        }
        System.out.println();
    }
}
