package com.lessons.sockets;

import com.lessons.BodyOfChat;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AppClient {
    public static void main(String[] args) throws IOException {
        int port = 9130;
        String adress = "127.0.0.1";
        InetAddress inetAddress = InetAddress.getByName(adress);

        Socket client = new Socket(inetAddress, port);

        System.out.println("Successfully connected");
        System.out.println("Write your message");

        InputStream input = client.getInputStream();
        OutputStream output = client.getOutputStream();

        DataInputStream inputData = new DataInputStream(input);
        DataOutputStream outputData = new DataOutputStream(output);

        Scanner scan = new Scanner(System.in);

        Thread op = new Thread(() ->{
            String line2 = null;
            while (scan.hasNext()){
                line2 = scan.nextLine();
                try {
                    outputData.writeUTF(line2);
                    outputData.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread ip = new Thread(() ->{
            String line = null;
            while (true){
                try {
                    line = inputData.readUTF();
                    System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        op.start();
        ip.start();

    }
}
