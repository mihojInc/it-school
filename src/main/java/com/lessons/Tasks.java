package com.lessons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 * Three task for lesson work
 */
public class Tasks {

    public String threadNameAndTime() {
        return Thread.currentThread().getName() + " -> " + (new Date().getTime() - App.STARTTIME + " ms");
    }

    /**
     * Write text in the file
     *
     * @param text     - our string for write
     * @param path     - blabla.txt
     * @param isAppend - write mode
     */
    public static synchronized void writeInFile(String text, String path, boolean isAppend) {

        try {
            text += "\n";

            if (isAppend) {
                Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
            } else {
                Files.write(Paths.get(path), text.getBytes());
            }
        } catch (IOException e) {
            System.out.println("c't write sorry");
        }
    }

    /**
     * Count fibbonachi sequence for 'to' position
     */
    public Integer fibonachiCount(int to) {

        int a = 0, b = 1, c = 0;
        if (to < 2) {
            return 0;
        } else {
            for (int i = 2; i < to; i++) {
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;
    }

    static {
        writeInFile("RESULT:", App.REPORT, false);
    }
}
