package com.lessons;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BodyOfChat {

    public Socket connectAsServer() throws IOException {
        int port = 9130;
        ServerSocket server = new ServerSocket(port);

        System.out.println("Waiting for connection with client...");
        Socket socket = server.accept();

        System.out.println("Get a client");
        return socket;
    }

    public Socket connectAsClient() throws IOException{
        int port = 9130;
        String adress = "127.0.0.1";
        InetAddress inetAddress = InetAddress.getByName(adress);

        Socket client = new Socket(inetAddress, port);

        System.out.println("Successfully connected");
        System.out.println("Write your message");
        return client;
    }

    public void chatWork(Socket soket) throws IOException {
        InputStream input = soket.getInputStream();
        OutputStream output = soket.getOutputStream();

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
