package com.lessons.Server;

import java.io.*;
import java.net.Socket;

public class ServerSomething extends Thread {

    //Сокет через который клиент будет общаться с сервером
    private Socket clientSocket;

    //Поток записи в сокет и чтения из него
    private BufferedReader inMessage;
    private BufferedWriter outMassage;

    //Constructor
    public ServerSomething(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        inMessage = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        outMassage = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        //Вызываем поток с методом run
        new Thread().start();
    }

    @Override
    public void run() {
        String message;
        try {
            message = inMessage.readLine();
            outMassage.write(message + "\n");
            outMassage.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                message = inMessage.readLine();
                if (message.equals("exit")) {
                    downService();
                    break;
                }
                System.out.println("User message:" + message);

            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод в котором отсылается одно сообщение клиенту по указанному потоку
     * @param message
     */
    private void send(String message) {
        try {
            outMassage.write(message + "\n");
            outMassage.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод который закрывает сервер
     */
    private void downService() {
        try {
            if (!clientSocket.isClosed()) {
                clientSocket.close();
                inMessage.close();
                outMassage.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
