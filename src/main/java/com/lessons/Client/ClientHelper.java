package com.lessons.Client;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHelper {
    //Клиентский socket
    private Socket clientSocket;

    private BufferedReader inMessage; //чтения из сокета
    private BufferedWriter outMessage; //чтения в сокет
    private BufferedReader readingFromConsole; //чтения с консоли

    private String host; //хост клиента
    private int port; //порт соединения

    private String userName; //имя клиента

    private Date date;
    private String time;
    private SimpleDateFormat simpleDateFormat;

    /**
     * The constructor takes the host and port number
     * @param host
     * @param port
     */

    public ClientHelper(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            this.clientSocket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //чтения из сокета, запись в сокет, и чтения с консоли
            readingFromConsole = new BufferedReader(new InputStreamReader(System.in));
            inMessage = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outMessage = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            //В начале спрашиваем имя пользователя
            this.pressNickname();
            new ReadMessage().start();
            new WriteMessage().start();
        } catch (IOException e) {
            downService();
        }
    }

    /**
     * The method in which the user enters a name and then sends it to the server
     */
    private void pressNickname() {
        System.out.println("Client started!");
        System.out.print("Enter your name please: ");
        try {
            userName = readingFromConsole.readLine();
            outMessage.write("Hello! " + userName + "\n");
            outMessage.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * The method in which clientSocket is closed
     */
    private void downService() {
        try {
            if (!clientSocket.isClosed()) {
                clientSocket.close();
                inMessage.close();
                outMessage.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A class that reads a message from the server
     */
    public class ReadMessage extends Thread {
        @Override
        public void run() {
            String message;
            try {
                while (true) {
                    //Ждем сообщение с сервера
                    message = inMessage.readLine();
                    if (message.equals("stop")) {
                        downService();
                        break;
                    }
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * A class that sends a message from the console to the server
     */
    public class WriteMessage extends Thread {
        @Override
        public void run() {
            while (true) {
                String userString;
                try {
                    date = new Date(); //Текущая дата
                    //Задаем время: час, минуты, секунды
                    simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                    time = simpleDateFormat.format(date);
                    //Сообщение с консоли отправляем на сервер
                    userString = readingFromConsole.readLine();
                    outMessage.write("(" + time + ") " + userName + ": " + userString + "\n");
                    outMessage.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
