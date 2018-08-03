package com.lessons;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
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
            System.out.println("Ip for connection: " + yourIp() + " or local: " + InetAddress.getLocalHost().getHostAddress());
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
     * Get your Ip for internet connection
     * https://stackoverflow.com/questions/8083479/java-getting-my-ip-address
     */
    private String yourIp() throws IOException{
        URL url = new URL("http://checkip.amazonaws.com/");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        return br.readLine();
    }

    private String clientConnect() {
        System.out.println("Input ip for connection:");
        String ip = scanner.nextLine();
        return ip.length() > 0 ? ip : HOST;
    }
}
