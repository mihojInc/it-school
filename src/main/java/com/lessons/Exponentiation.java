package com.lessons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exponentiation extends Thread{
    //Fields
    private String nameExponent;
    private List<Double> integerList = new ArrayList<>();

    //Constructor
    public Exponentiation(String nameExponent) {
        this.nameExponent = nameExponent;
    }
    //Getters
    public String getNameExponent() {
        return nameExponent;
    }

    @Override
    public void run() {
        System.out.println("START METHOD EXPONENT!");
        try {
            sleep(1000L);
            exponentiation(5,7);
            recordFile(new File("/home/denis/Programming/it-school/src/main/java/com/lessons/FileExponent"), integerList);
        } catch (InterruptedException e) {
            System.out.println("The method did not work correctly!");
        }
        System.out.println("END METHOD EXPONENT!");
    }

    /**
     * Method of exponentiation
     * @param a
     * @param b
     */
    public void exponentiation(double a, double b) {
        double value;
        for (int i = 0; i < 5; i++) {
            value = Math.pow(a, b);
            System.out.println(value);
            integerList.add(value);
        }
    }

    /**
     * Method for writing text to a file
     * @param file - accepts the input file
     * @param number - list of numbers
     */
    public void recordFile(File file, List<Double> number) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            if(file.exists()) {
                for (Double eDouble : number) {
                    bufferedWriter.write( eDouble + "\n");
                }
                System.out.println("Recording was successful!");
            } else {
                System.out.println("FileExponent not found! The recording didn't work!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
