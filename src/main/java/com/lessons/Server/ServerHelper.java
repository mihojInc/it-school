package com.lessons.Server;

import java.io.*;
import java.net.Socket;

public class ServerHelper extends Thread {
    //Сокет через который сервер общается с клиентом
    private Socket socket;
    private BufferedReader inMessage;
    private BufferedWriter outMessage;

    //Constructor
    public ServerHelper(Socket socket) throws IOException {
        this.socket = socket;
        inMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outMessage = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    @Override
    public void run() {
        String message;
        try {
            //Первое сообщение это имя пользователя
            message = inMessage.readLine();
            try {
                outMessage.write(message + "\n");
                outMessage.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                while (true) {
                    message = inMessage.readLine();
                    if(message.equals("stop")) {
                        downService();
                        break;
                    }
                    System.out.println("User correspondence history: " + message);
                    for (ServerHelper serverHelper : App.clientList) {
                        serverHelper.send(message);
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * In this method, we send a message to the user
     * @param message
     */
    private void send(String message) {
        try {
            outMessage.write(message + "\n");
            outMessage.flush();
        } catch (IOException ignored) {}
    }

    /**
     * In this method, we close the server and remove users from the list
     */
    private void downService() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                inMessage.close();
                outMessage.close();
                for (ServerHelper serverHelper : App.clientList) {
                    if(serverHelper.equals(this)) serverHelper.interrupt();
                    App.clientList.remove(this);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
