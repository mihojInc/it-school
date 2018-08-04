package com.lessons.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class App {
    static final int PORT = 3434;
    //Список всех пользователей
    static List<ServerHelper> clientList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started!");
        try {
            while (true) {
                //Метод accept ждет пока его дернут
                Socket socket = serverSocket.accept();
                try {
                    clientList.add(new ServerHelper(socket));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            serverSocket.close();
        }
    }
}
