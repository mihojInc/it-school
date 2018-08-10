package com.lessons.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

public class Server {
    static final int PORT = 3434;
    static final String IP_ADDRESS = "192.168.0.104";
    //Адрес с хостингом сервера
    InetAddress inetAddress = InetAddress.getByName(IP_ADDRESS);

    private final String INITIAL_MESSAGE = "The server was successfully started. Have a nice chat!";

    //Список всех пользователей
    static List<ServerHelper> clientList = new LinkedList<>();

    public Server() throws UnknownHostException {}

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT,5, inetAddress);
        System.out.println(INITIAL_MESSAGE);
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
