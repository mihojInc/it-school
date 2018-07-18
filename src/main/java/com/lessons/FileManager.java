package com.lessons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void clearFile(File file) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(" ");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("File in cleaning.");
        }
    }

    /**
     * Method for writing text to a file
     * @param text - Some text
     */
    public static void recordFile(String text) {
        File file = new File("/home/denis/Programming/it-school/src/main/java/com/lessons/FileProduct");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            if (file.exists()) {

                bufferedWriter.write(text + " \n");
                bufferedWriter.flush();
            } else {
                System.out.println("The recording didn't work!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


