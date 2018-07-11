package com.lessons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MultiThread extends Thread{
    //Fields
    private String nameMulti;
    private List<Integer> integerList = new ArrayList<>();

    //Constructor
    public MultiThread(String nameMulti) {
        this.nameMulti = nameMulti;
    }
    //Getters
    public String getNameMulti() {
        return nameMulti;
    }

    @Override
    public void run() {
        System.out.println("START METHOD MULTI!");
        try {
            sleep(1000L);
            multiThread(5);
            recordFile(new File("/home/denis/Programming/it-school/src/main/java/com/lessons/FileMulti"),integerList);
        } catch (InterruptedException e) {
            System.out.println("The method did not work correctly!");
        }
        System.out.println("END METHOD MULTI!");
    }

    public void multiThread(int value) {
        for (int i = 0; i < 5; i++) {
            value = i;
            value = (value + 1) * 2;
            integerList.add(value);
            System.out.println(value);
        }
    }

    /**
     * Method for writing text to a file
     * @param file - accepts the input file
     * @param number - list of numbers
     */
    public void recordFile(File file, List<Integer> number) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            if(file.exists()) {
                for (Integer integer : number) {
                    bufferedWriter.write(integer + "\n");
                }
                System.out.println("Recording was successful!");
            } else {
                System.out.println("FileMulti not found! The recording didn't work!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
