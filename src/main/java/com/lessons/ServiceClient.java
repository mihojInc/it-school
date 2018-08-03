package src.main.java.com.lessons;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ServiceClient {
    public static void startClient() throws IOException, InterruptedException {
        Scanner c = new Scanner(System.in);
        System.out.println("Please input port:");
        int port = c.nextInt();
        System.out.println("Please input server ip-adress:");
        String adress = c.next();
        System.out.println("Client is starting ..");
        InetAddress inetAddress = InetAddress.getByName(adress);
        Socket client = new Socket(inetAddress,port);//just socket
        System.out.println("Successfully connected!");// if connect successful

        InputStream is = client.getInputStream(); //canal of connect
        OutputStream os = client.getOutputStream();

        DataInputStream dataInputStream = new DataInputStream(is);
        DataOutputStream dataOutputStream = new DataOutputStream(os);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // read console
        String outline = null;
        //receiving messages from the server in a separate thread
        Thread inputThread = new Thread(() ->{
            while (true){
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

        while (!client.isOutputShutdown()){  //Is the socket live?
            if (keyboard.ready()){
                outline = keyboard.readLine();
                dataOutputStream.writeUTF(outline);
                dataOutputStream.flush();
            }
        }

    }
}
