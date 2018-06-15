package com.lessons;

import java.util.Random;
import java.util.Scanner;

/**
 * This class describe game
 */
public class Game {


    /**
     * Thsi array save current statment in the game
     */
    private String[][] play = new String[3][3];
    private Scanner sc;
    /**
     * winner save type of winnew
     */
    private Players winner;

    private boolean draw = true;

    public Game(Scanner sc) {
        this.sc = sc;
        initial();
    }

    public void playGame() {

        initial();
        //draw dashboard in current statment
        DashBoard.draw(play);
        //main loob of game. Loop is brake when user answer is exit

        while (true) {

            while (!analizeWin()) {
                //player step
                step(Players.PLAYER);
                if (analizeWin()) break;
                DashBoard.draw(play);
                System.out.println("Computer step");
                step(Players.COMPUTER);
                DashBoard.draw(play);
            }


            DashBoard.draw(play);

            System.out.println("\n" + winner.getRusName() + " win");

            System.out.println("Continue game? y/n");
            if (!sc.nextLine().equals("y")) break;
        }


    }


    /**
     * First initialization array symbol ""
     */
    public void initial() {
        for (int i = 0; i < 3; i++)
            for (int k = 0; k < 3; k++)
                play[i][k] = "";
    }

    /**
     * @param pos    position where will step player
     * @param player type of player if its is computer or player
     * @return if all ok return true, is was something trouble return false
     */
    public void step(Players player) {
        //Create random calss for computer step
        Random rnd = new Random(System.currentTimeMillis());


        while (true) {
            //chek if chois is incorrect. we can choise only from 1 to 9

            int pos = (player == Players.PLAYER) ? sc.nextInt() : rnd.nextInt(9);
            if (1 > pos || pos > 10) {
                if (player == Players.PLAYER)
                    System.out.println("Try more");
                continue;
            }


            //int s = ((pos-1) % 3)==0?2:(pos % 3)-1;
            int s = ((pos - 1) % 3); //calculate position
            int f = ((pos - 1) / 3); //calculate position
            if (play[f][s].equals("")) { //check if this spot is free, another way return false
                play[f][s] = player.getMark();
                return;
            } else {
                System.out.println(player == Players.PLAYER ? "Try more" : "");
                continue;
            }

        }
    }

    /**
     * This procedure draw dashboard
     */
//    public void draw() {
//
//        int i = 0;
//        int k = 0;
//        for (i = 0; i < 3; i++) {
//            for (k = 0; k < 3; k++) {
//
//                if (k == 2) {
//
//                    if (!dash[i][k].equals("")) {//check if this spot is free
//
//                        if (i != 2) // check if its spot is last. We have to drow another line in last spots
//                            System.out.print(dash[i][k] + "_");
//                        else
//                            System.out.print(dash[i][k] + "  ");
//                    } else {
//                        if (i != 2)
//                            System.out.print("__");
//
//
//                    }
//                    continue;
//                }
//
//
//                if (!dash[i][k].equals("")) {
//
//                    if (i != 2)
//                        System.out.print(dash[i][k] + "_|");
//                    else System.out.print(dash[i][k] + " |");
//
//
//                } else {
//                    if (i != 2)
//                        System.out.print("__|");
//                    else {
//                        System.out.print("  |");
//                    }
//
//                }
//
//
//            }
//
//            System.out.println();
//
//
//            k = 0;
//        }
//
//    }

    /**
     * Clear arrray
     */
    public void clear() {
        play = new String[3][3];
    }

    /**
     * This procedure finde a winner
     *
     * @return who win
     */
    public boolean analizeWin() {

        //chech if there is a diagonal line
        if ((play[0][0].equals(play[1][1]) && play[1][1].equals(play[2][2]))
                || (play[0][2].equals(play[1][1]) && play[1][1].equals(play[2][0]))) {
            if (play[1][1].equals(""))//it can be diagonal line, but free spot. Here we check it
                return false;

            if (Players.PLAYER.getMark().equals(play[0][0]))
                winner = Players.PLAYER;
            else
                winner = Players.COMPUTER;

            return true;
        }
        for (int i = 0; i < 3; i++) {//Chech horisontal and vertical lines
            if ((play[0][i].equals(play[1][i]) && play[1][i].equals(play[2][i]))
                    || (play[i][0].equals(play[i][1]) && play[i][1].equals(play[i][2]))) {

                if (play[0][i].equals("") || play[i][1].equals(""))
                    return false;

                if (Players.PLAYER.getMark().equals(play[0][0]))
                    winner = Players.PLAYER;
                else
                    winner = Players.COMPUTER;

                return true;
            }
        }

        draw = true;
        for (int i = 0; i < 3; i++)
            for (int k = 0; k < 3; k++) {
                if (play[i][k].equals(""))//analize if the draw
                    draw = false;

            }
        if (draw)
            return true;
        return false;
    }

    /**
     * @return who win the game
     */


        //return winner.equals("0") ? "Computer win" : "Player win";


}