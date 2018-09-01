package com.lessons.Client;

import com.lessons.Common.AnswerAfterStep;
import com.lessons.Common.Colors;
import com.lessons.Common.DashBoard;
import com.lessons.Common.Statment;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientManager {

    private Socket client;
    private ObjectOutputStream objOut = null;
    private ObjectInputStream objIn = null;
    private Scanner sc = new Scanner(System.in);
    private BufferedReader dataInputStreamP;
    private BufferedWriter dataOutputStreamP;
    private Colors color;
    private Statment statment = new Statment();

    public ClientManager() {

        System.out.println("Enter addres");
//      String adress = sc.nextLine();
        String adress = "127.0.0.1";

        System.out.println("Enter port");
//      int port = sc.nextInt();
        int port = 9192;

        try {
            InetAddress inetAddress = InetAddress.getByName(adress);
            client = new Socket(inetAddress, port);
            setStreams();
            stepPlayer();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    private void setStreams() throws Exception {

        dataOutputStreamP = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        dataInputStreamP = new BufferedReader(new InputStreamReader(client.getInputStream()));

        objOut = new ObjectOutputStream(client.getOutputStream());
        objIn = new ObjectInputStream(client.getInputStream());

        String ans = dataInputStreamP.readLine();
        if (ans.equals("White")) {
            color = Colors.WHITE;

        } else {
            color = Colors.BLACK;
        }

    }

    public void stepPlayer() throws Exception {
        DashBoard.draw(statment);
//        System.out.println("Step " + statment.getCurPlayer());
        int x;
        int y;
        int x_new;
        int y_new;
        while (true) {
            statment = (Statment) objIn.readObject();
            DashBoard.draw(statment);
            if (statment.getAns() == AnswerAfterStep.WNNER) {
                System.out.println("Player + " + statment.getCurPlayer() + " win");
            }
            System.out.println("Step " + color.getDesc());
            System.out.println("Take figure");
            while (true) {
                x = sc.nextInt();
                y = sc.nextInt();

                dataOutputStreamP.write(x);
                if (x == 99) break;
                dataOutputStreamP.write(y);
                dataOutputStreamP.flush();

                AnswerAfterStep ans = (AnswerAfterStep) objIn.readObject();
                if (ans == AnswerAfterStep.WRONG_STEP) {
                    System.out.println("Incorrect step");
                    continue;
                } else {
                    break;
                }

            }
            System.out.println("Aim");
            while (true) {
                x_new = sc.nextInt();
                y_new = sc.nextInt();

                dataOutputStreamP.write(x_new);
                dataOutputStreamP.write(y_new);
                dataOutputStreamP.flush();
                AnswerAfterStep ans = (AnswerAfterStep) objIn.readObject();
                if (ans == AnswerAfterStep.WRONG_STEP) {
                    System.out.println("Incorrect step");
                    continue;
                } else {
                    break;
                }
            }
            statment = (Statment) objIn.readObject();

            if (statment.getAns() == AnswerAfterStep.WNNER) {
                System.out.println("Player + " + statment.getCurPlayer() + " win");
            }
            DashBoard.draw(statment);
        }
    }
}
