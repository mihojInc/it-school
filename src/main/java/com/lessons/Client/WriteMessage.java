package com.lessons.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteMessage extends Thread {
    private BufferedReader inMessage; //Входящее сообщение
    private BufferedWriter outMessage; //Исходящее сообщение
    private BufferedReader inputUser; //Поток чтения с консоли

    private String userName; //Имя пользователя
    private Date time;
    private String dtime;
    private SimpleDateFormat simpleDate;

    @Override
    public void run() {
        while (true) {
            String userMessage;
            try {
                time = new Date(); // текущая дата
                simpleDate = new SimpleDateFormat("HH:mm:ss"); // берем только время до секунд
                dtime = simpleDate.format(time); // время
                userMessage = inputUser.readLine(); // сообщения с консоли
                if (userMessage.equals("stop")) {
                    outMessage.write("stop" + "\n");
                    break; // выходим из цикла если пришло "stop"
                } else {
                    // отправляем на сервер
                    outMessage.write("(" + dtime + ") " + userName + ": " + userMessage + "\n");
                    outMessage.flush(); // выталкиваем
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }
}
