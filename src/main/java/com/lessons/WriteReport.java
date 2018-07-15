package com.lessons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Writer-Reader helper
 */
public class WriteReport {

    private final static String PATH = "../it-school/src/main/resources/report.txt";

    public synchronized static void write(String message) {
        try {
            message += "\n";
            Files.write(Paths.get(PATH), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("c't write sorry");
        }
    }

    /**
     * Count from report file all operation with goods and write them
     */
    public static void countAndWriteAllStory() {
        try {
            byte[] fileInBytes = Files.readAllBytes(Paths.get(PATH));
            String report = new String(fileInBytes);
            System.out.println("--------------RESULT-------------------\n" +
                            "Item - produce / buy\n" +
                            "milk - " + (report.split("produce milk").length - 1) + " / " + (report.split("buy milk").length - 1) + "\n"
                            + "meat - " + (report.split("produce meat").length - 1) + " / " + (report.split("buy meat").length - 1) + "\n"
                            + "fish - " + (report.split("produce a fish").length - 1) + " / " + (report.split("buy a fish").length - 1)

            );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Clear report file
     */
    static {
        try {
            Files.write(Paths.get(PATH), "".getBytes());
        } catch (IOException e) {
            System.out.println("c't write sorry");
        }
    }


}
