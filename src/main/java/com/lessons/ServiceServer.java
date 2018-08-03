package src.main.java.com.lessons;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServiceServer {
    public static void startServer() throws IOException, InterruptedException {
        int port;
        Scanner p = new Scanner(System.in);
        System.out.print("Please input port:");
        port = p.nextInt();
        ServerSocket server = new ServerSocket(port);
        System.out.println();
        System.out.println("Server is starting. Waiting for client.. ");
        Socket socket = server.accept(); //app is sleep
        System.out.println("Got a client");

        InputStream is = socket.getInputStream(); //canal of connect
        OutputStream os = socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DataInputStream dataInputStream = new DataInputStream(is);
        DataOutputStream dataOutputStream = new DataOutputStream(os);

        String outputline = null;
        //receiving messages from the client in a separate thread
        Thread inputThread = new Thread(() -> {
            while (true) {
                String inputline = null;
                try {
                    inputline = dataInputStream.readUTF();
                    System.out.println(inputline);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        inputThread.start();

        while (!socket.isClosed()) {  //Is the socket live?
            outputline = p.next();
            dataOutputStream.writeUTF(outputline);
            dataOutputStream.flush();

        }
    }
}
