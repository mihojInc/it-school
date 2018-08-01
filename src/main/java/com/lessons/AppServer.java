package java.com.lessons;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServer {
    public static void main(String[] args) throws IOException {
        int port =9130;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Waiting for client.. ");
        Socket socket = server.accept(); //app is sleep
        System.out.println("Got a client");

        InputStream is = socket.getInputStream(); //canal of connect
        OutputStream os = socket.getOutputStream();

        DataInputStream dataInputStream = new DataInputStream(is);
        DataOutputStream dataOutputStream = new DataOutputStream(os);

        String line = null;
        while (true){
            line = dataInputStream.readUTF();
            System.out.println("client send line to server");
            System.out.println(line);

            System.out.println("Send this line to client");
            dataOutputStream.writeUTF(line);
            dataOutputStream.flush();

            System.out.println("waiting for next line");

            System.out.println();
        }

    }
}
