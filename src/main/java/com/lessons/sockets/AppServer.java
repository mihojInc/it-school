package com.lessons.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AppServer {
    public static void main(String[] args) throws IOException {
        int port = 9130;
        ServerSocket server = new ServerSocket(port);

        System.out.println("Waiting for connection with client...");
        Socket socket = server.accept();

        System.out.println("Get a client");

        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        DataInputStream inputData = new DataInputStream(input);
        DataOutputStream outputData = new DataOutputStream(output);

        Scanner scan = new Scanner(System.in);

        Thread ip = new Thread(() ->{
            String line = null;

            while (!server.isClosed()){
                try {
                    line = inputData.readUTF();
                    System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread op = new Thread(() ->{
            String line2 = null;
            while (scan.hasNext() && !server.isClosed()){
                line2 = scan.nextLine();
                try {
                    outputData.writeUTF(line2);
                    outputData.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ip.start();
        op.start();

    }
}
