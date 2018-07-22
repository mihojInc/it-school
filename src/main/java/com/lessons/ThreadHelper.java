package com.lessons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ThreadHelper {

    /**
     * Method of cleaning the file before each thread start
     */
    public static void clearFile() {
        File file = new File("/home/denis/Programming/it-school/src/main/java/com/lessons/File");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(" ");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("File in cleaning.");
        }
    }

    /**
     * Method for writing text to a file
     */
    public static void recordFile() {
        File file = new File("/home/denis/Programming/it-school/src/main/java/com/lessons/File");
        String nameThread = Thread.currentThread().getName();
        Long timeThread = System.nanoTime();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))){
            bufferedWriter.write("Second thread name: " + nameThread + " Time thread: " + timeThread);
            bufferedWriter.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method in which a Fibonacci method is written to a file
     * @param text - Any method can be written here
     */
    public static void writeFibonacci(String text) {
        Path FILE_PATH = Paths.get("/home/denis/Programming/it-school/src/main/java/com/lessons/File");
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(FILE_PATH, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
        bufferedWriter.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
