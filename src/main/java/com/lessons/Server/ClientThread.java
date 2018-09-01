package com.lessons.Server;

import com.lessons.Common.*;

import java.io.*;
import java.net.Socket;

/**
 * Поток который управляет одним из клиентов
 */
public class ClientThread extends Thread {

    private static int count = 0;
    private Colors colorPlayer;
    private Socket clientDialog;
    private ObjectOutputStream objOut;
    private ObjectInputStream objIn;
    private BufferedWriter out;
    private BufferedReader in;


    public ClientThread(Socket socket, Colors colorPlayer) {
        this.clientDialog = socket;
        this.colorPlayer = colorPlayer;
    }

    @Override
    public void run() {
        getStreams();
        operations();
    }

    public void getStreams() {
        try {
            out = new BufferedWriter(new OutputStreamWriter(clientDialog.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(clientDialog.getInputStream()));

            objOut = new ObjectOutputStream(clientDialog.getOutputStream());
            //objOut.flush();
            objIn = new ObjectInputStream(clientDialog.getInputStream());

            out.write(colorPlayer.getDesc() + "\n");
            out.flush();

        } catch (IOException e) {
            System.out.println("Opps...!");
        }
    }

    public void operations() {
        try {

            if (colorPlayer == Colors.WHITE) {
                objOut.writeObject(GamePlay.getStatment());
                objOut.flush();
            }
            int x = 0;
            int y = 0;
            int x_new = 0;
            int y_new = 0;
            while (!clientDialog.isClosed()) {
                while (GamePlay.getCurClients() == this) {

                    DashBoard.draw(GamePlay.getStatment());
                    System.out.println("Step player " + colorPlayer.getDesc());

                    while (true) {
                        x = in.read();
                        y = in.read();
                        if (GameAnalizator.availableFigureForStep(GamePlay.getStatment(), x, y) == null) {
                            System.out.println("Wrong figure for step");
                            objOut.writeObject(AnswerAfterStep.WRONG_STEP);
                            out.flush();
                        } else {
                            objOut.flush();
                            objOut.writeObject(AnswerAfterStep.CORRECT_STEP);
                            out.flush();
                            break;
                        }
                    }

                    while (true) {
                        System.out.println("AIM");
                        x_new = in.read();
                        if (x_new == 99) {
                            clientDialog.close();
                            break;
                        }
                        y_new = in.read();
                        if (!GameAnalizator.coorrectStep(GamePlay.getStatment(),x,y, x_new, y_new)) {
                            System.out.println("Wrong aim for step");
                            objOut.writeObject(AnswerAfterStep.WRONG_STEP);
                            objOut.flush();
                        } else {
                            objOut.writeObject(AnswerAfterStep.CORRECT_STEP);
                            objOut.flush();
                            break;
                        }
                    }

                    System.out.println("Player " + colorPlayer.getDesc() + " step x=" + x + " ;y=" + y);

                    GamePlay.makeStepServer(x, y, x_new, y_new);

                    objOut.writeObject(GamePlay.getStatment());
                    objOut.flush();
                    if(GameAnalizator.winner(GamePlay.getStatment())){
                        System.out.println("Player + " + colorPlayer + " win");
                        GamePlay.sendStateToAnother();
                        break;
                    }
                    GamePlay.changePlayer();
                    GamePlay.sendStateToAnother();
                }
            }
            System.out.println("Client disconnected");

            in.close();
            out.close();

            clientDialog.close();

        } catch (IOException e) {
            System.out.println("Opps...!");
            e.printStackTrace();
        }
    }

    public void sendStatment(Statment statment) throws IOException {
        objOut.writeObject(statment);
//        System.out.println("Send to " + colorPlayer);
        objOut.flush();
    }
}