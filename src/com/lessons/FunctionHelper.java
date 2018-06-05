package com.lessons;

/**
 * class for function
 */
public class FunctionHelper {
    /**
     * print fibonacci numbers
     */
    public static void printFibonacciNumbers(long n) {
        if(n==0){
            System.out.println(0);
            return;
        }
        System.out.print(0+" ");
        long previous = 0;
        long next = 1;
        long newNumber=1;
        while (n >= newNumber){
            System.out.print(newNumber +" ");
            newNumber=previous+next;
            previous=next;
            next=newNumber;
        }
    }
}
