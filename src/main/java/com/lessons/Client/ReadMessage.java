package com.lessons.Client;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadMessage extends Thread {

    private BufferedReader inMessage; //Входящее сообщение

    @Override
    public void run() {
        String message;
        try {
            while (true) {
                message = inMessage.readLine();
                if (message.equals("exit")) {
                    break;
                }
                System.out.println(message);
            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
    }
}
