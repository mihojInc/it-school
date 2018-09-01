package com.lessons.Server;

import java.net.ServerSocket;
import java.net.Socket;


/**
 * Class witch describe server answers about connecting players
 */
public class CheckersServer {
    public int countCl=0;

    public Socket connectPlayer()throws Exception{
        int port = 9192;
        return new Socket("127.0.0.1",port);
    }
    public ServerSocket connectServer()throws Exception{
        int port = 9192;
        return new ServerSocket(port);
    }
}
