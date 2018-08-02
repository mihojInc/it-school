package com.lessons.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class App {
    //Порт, который будет случшать сервер
    private static final int PORT = 3443;
    //Список пользователей, который будут подключаться к серверу
    private static List<ServerSomething> clientsList = new ArrayList();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started!");

        while (true) {
            try {
                //Блокируется до нового соединения
                Socket socket = serverSocket.accept();
                //Добавляем нового пользователя в список
                clientsList.add(new ServerSomething(socket));
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
