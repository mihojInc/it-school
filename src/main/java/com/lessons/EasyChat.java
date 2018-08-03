package com.lessons;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Chat for two humans
 */
public class EasyChat {

    private static final int PORT = 9120;
    private static final String HOST = "127.0.0.1";
    Scanner scanner = new Scanner(System.in);

    public void start() throws IOException {

        System.out.println("'s'- create server, else - client");
        String choise = scanner.nextLine();

        Socket socket;

        if (choise.equals("s")) {
            ServerSocket ss = new ServerSocket(PORT);
            socket = ss.accept();
        } else {
            InetAddress inetAddress = InetAddress.getByName(clientConnect());
            socket = new Socket(inetAddress, PORT);
        }

        System.out.println("connect success!!!");

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        DataInputStream dataInputStream = new DataInputStream(is);
        DataOutputStream dataOutputStream = new DataOutputStream(os);

        Writer writeMessage = new Writer(dataOutputStream);
        Thread writerThread = new Thread(writeMessage);

        //write in chat
        writerThread.start();

        //read for chat
        while (true) {
            System.out.println(dataInputStream.readUTF());
        }
    }

    /**
     * Input address, or d't input
     */
    private String clientConnect() {
        System.out.println("Input ip for connection:");
        String ip = scanner.nextLine();
        return ip.length() > 0 ? ip : HOST;
    }
}
