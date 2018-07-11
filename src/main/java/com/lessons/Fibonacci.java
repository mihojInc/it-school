package com.lessons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Fibonacci extends Thread{
    //Fields
    private String nameFib;
    private Set<Integer> integerSet = new HashSet<>();

    //Constructor
    public Fibonacci(String nameFib) {
        this.nameFib = nameFib;
    }
    //Getters
    public String getNameFib() {
        return nameFib;
    }

    @Override
    public void run() {
        System.out.println("START METHOD FIBONACCI!");
        try {
            sleep(1000L);
            fibonacciNumbers(30);
            recordFile(new File("/home/denis/Programming/it-school/src/main/java/com/lessons/FileFibonacci"),integerSet);
        } catch (InterruptedException e) {
            System.out.println("The method did not work correctly!");
        }
        System.out.println("END METHOD FIBONACCI!");

    }

    /**
     * Calculating the Fibonacci number
     * @param value - fibonacci number
     */
    public void fibonacciNumbers(int value) {
        int a = 1, b = 1;
        for (int i = 2; i <= 10; i++) {
            value = a + b;
            System.out.println(value + " ");
            b = b + a;
            a = b - a;
        }
        integerSet.add(value);
    }

    /**
     * Method for writing text to a file
     * @param file - accepts the input file
     * @param number - list of numbers
     */
    public void recordFile(File file, Set<Integer> number) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            if(file.exists()) {
                for (Integer integer : number) {
                    bufferedWriter.write(integer + "\n");
                }
                System.out.println("Recording was successful!");
            } else {
                System.out.println("FileFibonacci not found! The recording didn't work!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
