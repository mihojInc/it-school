package com.lessons;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Provide input for console in another thread
 */
public class Writer implements Runnable {

    private DataOutputStream dataOutputStream;
    Scanner scanner = new Scanner(System.in);

    /**
     * @param dataOutputStream - give out stream for chat
     */
    public Writer(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void run() {
        while (true) {

            try {
                dataOutputStream.writeUTF(scanner.nextLine());
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
