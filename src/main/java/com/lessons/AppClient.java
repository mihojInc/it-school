package src.main.java.com.lessons;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class AppClient {
    public static void main (String[] args) throws IOException {

        int port = 9130;
        String adress = "127.0.0.1";
        InetAddress inetAddress = InetAddress.getByName(adress);
        Socket client = new Socket(inetAddress,port);//just socket
        System.out.println("Successfully connected!");// if connect successful

        InputStream is = client.getInputStream(); //canal of connect
        OutputStream os = client.getOutputStream();

        DataInputStream dataInputStream = new DataInputStream(is);
        DataOutputStream dataOutputStream = new DataOutputStream(os);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // read console
        String line = null;

        System.out.println("type something to console for send it to server");

        while (true){
            line = keyboard.readLine();
            System.out.println("sending info for server");

            dataOutputStream.writeUTF(line);
            dataOutputStream.flush();

            System.out.println("successfully send info to server");

            System.out.println("Waiting for server answer ....");

            System.out.println(dataInputStream.readUTF());

            System.out.println("Can repeat this");

        }
    }
}
