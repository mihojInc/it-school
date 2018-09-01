package com.lessons.Server;

import com.lessons.Common.Colors;
import com.lessons.Common.Figure;
import com.lessons.Common.Statment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class GamePlay {

    public static Colors curPlayer = Colors.WHITE;
    private static Statment statment = new Statment();
    private static ClientThread[] clients = {null, null};
    private CheckersServer server;
    private ServerSocket serverSocket;
    private Socket clientWhite;
    private Socket clientBlack;

    public GamePlay() {
        for (ClientThread clientThread : clients) {
            clientThread = new ClientThread(null, null);
        }
    }

    /**
     * Получаем поток текущего игрока
     * @return поток текущего игрока
     */
    public static ClientThread getCurClients() {
        return clients[statment.getCurPlayer().getIndex()];
    }

    /**
     * Procedure make step
     */
    public static void makeStepServer(int x_old, int y_old, int x_new, int y_new) {
        statment.makeStep(x_old, y_old, x_new, y_new);
    }

    /**
     * @return current ctatment of game
     */
    public static Statment getStatment() {
        return statment;
    }

    /**
     * @param x coordinate needed figure
     * @param y
     * @return firure wich on the туув ызще
     */
    public static Figure getFigure(int x, int y) {
        return statment.getFig(x, y);
    }

    /**
     * changing player after step
     */
    public static void changePlayer() throws IOException {
        if (statment.getCurPlayer() == Colors.BLACK)
            statment.setCurPlayer(Colors.WHITE);
        else
             statment.setCurPlayer(Colors.BLACK);
    }

    //sent to no active client current statment
    public static void sendStateToAnother()throws IOException {
             clients[statment.getCurPlayer().getIndex()].sendStatment(statment);
    }

    /**
     * Добавляем нового игрока в массив игроков
     *
     * @param client новый добавляемый игрок
     */
    public void addClient(ClientThread client) throws IOException{
        clients[statment.getCurPlayer().getIndex()] = client;
        changePlayer();
    }

    public void connectPlayer(Socket socket, Colors color) throws IOException {
        ClientThread thread = new ClientThread(socket, color);
        addClient(thread);
        thread.start();
        System.out.println(color.getDesc() + "  player connected");
    }

    public void gameStart() throws Exception {

        System.out.println("There is no servers...\nServer is starting");

        //создаем сервер
        server = new CheckersServer();

        //Подключили сервер
        serverSocket = server.connectServer();
        System.out.println("Server start");

        //Ждем первого клиента и подключаем его в новом потоке
        clientWhite = serverSocket.accept();
        connectPlayer(clientWhite, Colors.WHITE);

        //Ждем второго клиента и подключаем его в новом потоке
        clientBlack = serverSocket.accept();
        connectPlayer(clientBlack, Colors.BLACK);

        System.out.println("Both of clients was connected");
        System.out.println("Game start");

    }
}
