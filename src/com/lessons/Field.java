package com.lessons;

import java.util.Random;
import java.util.Scanner;

import static com.lessons.TicTacToe.CROSS;
import static com.lessons.TicTacToe.EMPTYCELL;

public class Field {
    /**
     * sizes of game field
     */
    public static final int COL = 3, STR = 3;
    /**
     * game field 3x3
     */
    private static String[][] gameField = new String[STR][COL];

    public static int getCOL() {
        return COL;
    }

    public static int getSTR() {
        return STR;
    }

    public static String getGameField(int x, int y) {
        return gameField[x][y];
    }

    public static void setGameField(int x, int y, String gameField) {
        Field.gameField[x][y] = gameField;
    }

    /**
     * it is the method to start game. This method creates empty game field
     */
    public static void startGame(){
        for(int i = 0; i < STR; i++){
            for(int j = 0; j < COL; j++){
                gameField[i][j] = EMPTYCELL;
            }
        }
        //currentGamer = CROSS;
        displayField();
    }

    /**
     * it will return true if game field is full
     */

    public static boolean isFull(){
        for(int i = 0; i < STR; i++){
            for(int j = 0; j < COL; j++) {
                if(gameField[i][j].equals(EMPTYCELL)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * method that displays game field on the console
     */
    public static void displayField(){
        for(int i = 0; i < STR; i++){
            for(int j = 0; j < COL; j++){
                System.out.print(gameField[i][j]);
                if(j != COL-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i != STR-1){
                System.out.println("------------");
            }
        }
        System.out.println();

    }

}
