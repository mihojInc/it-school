package com.lessons.Client;

import java.io.*;
import java.net.Socket;

public class ClientSomething {
    private Socket clientSocket;
    private BufferedReader inMessage; //Входящее сообщение
    private BufferedWriter outMessage; //Исходящее сообщение
    private BufferedReader inputUser; //Поток чтения с консоли

    private int port;
    private String host;

    private String userName; //Имя пользователя

    //Constructor
    public ClientSomething(int port, String host) {
        this.port = port;
        this.host = host;
        try {
            clientSocket = new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //Потоки чтения из сокета / записи в сокет, и чтения с консоли
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            inMessage = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outMessage = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            this.enterUserName();
            new ReadMessage().start(); //Читаем сообщение в бесконечном цикле
            new WriteMessage().start(); //Пишем собщение в бесконечном цикле
        } catch (IOException e) {
            //Закрываем сокет при любой ошибке
            ClientSomething.this.downService();
        }

    }

    //Метод в котором мы просим пользователя ввести свое имя
    private void enterUserName() {
        System.out.print("Entered your name: ");
        try {
            userName = inputUser.readLine();
            outMessage.write("Hello: " + userName + "\n");
            outMessage.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод закрытия всех сокетов
    private void downService() {
        try {
            if (!clientSocket.isClosed()) {
                clientSocket.close();
                inMessage.close();
                outMessage.close();
            }
        } catch (IOException ignored) {}
    }
}
