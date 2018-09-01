package com.lessons.Common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * содержит поведение игрока, его параметры для обмена сообщениями
 * список фигур
 * имя игрока
 * цвет
 *
 * также в этом классе описан поток чтения
 *
 * ввод информации и вывод выполняются в разных потоках
 *
 * данный клас содержится в классе игры
 */
public class Player {
    private Socket playerSocket;
    private DataOutputStream dataOutputStreamP;
    private DataInputStream dataInputStreamP;
    private ReadBuf rbP;
    private ArrayList<Figure> figure = new ArrayList<>();
    private String name;
    private Colors color;

    public void writeText(String text)throws Exception{
//        dataOutputStreamP.writeUTF(text);
    }

    /**
     * процедура инициализирует расставляет шашки по местам
     */
    public void firstInitial(){
//        for (int i=1;i<=3;i++){
//            if(i%2==0){
//                for(int k=2;k<=8;k+=2){
//                    figure.add(new Figure(i,k));
//                }
//            }else {
//                for(int k=1;k<=7;k+=2){
//                    figure.add(new Figure(i,k));
//                }
//            }
//        }
    }

    /**
     * конструктор инициализирует сокет для соединения с сервером, а также основные параметры
     * @param playerSocket
     */
    public Player(ServerSocket serverSocket, Colors color)  throws Exception{
//
//
//            this.playerSocket = serverSocket.accept();
//            dataInputStreamP = new DataInputStream(playerSocket.getInputStream());
//            dataOutputStreamP = new DataOutputStream(playerSocket.getOutputStream());
//            rbP = new ReadBuf(dataInputStreamP);

    }

    /**
     * Процедура проверяет если ли такая фигура
     * если есть то возвращает на нее ссылку, если нет null
     * @return
     */
    public Figure existFigure(int x, int y){
//        Iterator iterator = figure.iterator();
//        while(iterator.hasNext()){
//            Figure figure = (Figure) iterator.next();
//            if(figure.equals(x,y)) return figure ;
//        }
        return null;
    }

    /**
     * 3Процедура удаляет фигуру из текщей поции игрока
     * @return
     */
    public boolean deleteFigure(int x,int y){
//        Figure delFigure = existFigure(x,y);
//        figure.remove(delFigure);
//        //если была удалена последняя фигура текущий пользователь проиграл
//        if(figure.size()==0){
//            return true;
//        }
        return false;
    }
    /**
     * процедура меняет координаты фигуры игрока
     */
    public void changePlace(int x, int y){
//        Figure delFigure = existFigure(x,y);
//        delFigure.setCoord(x,y);
    }



}
