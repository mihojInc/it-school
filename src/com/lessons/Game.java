package com.lessons;

/**
 * This class describe game
 */
public class Game {

    /**
     * Thsi array save current statment in the game
     */
    private String[][] dash = new String[3][3];

    /**
     * winner save type of winnew
     */
    private String winner = "";

    boolean draw = true;

    public Game() {
        initial();
    }


    /**
     * First initialization array symbol ""
     */
    public void initial() {
        for (int i = 0; i < 3; i++)
            for (int k = 0; k < 3; k++)
                dash[i][k] = "";
    }

    /**
     *
     * @param pos position where will step player
     * @param player type of player if its is computer or player
     * @return if all ok return true, is was something trouble return false
     */
    public boolean step(int pos, boolean player) {
        //chek if chois is incorrect. we can choise only from 1 to 9
        if (1 > pos || pos > 10) {
            return false;
        }


        //int s = ((pos-1) % 3)==0?2:(pos % 3)-1;
        int s = ((pos - 1) % 3); //calculate position
        int f = ((pos - 1) / 3); //calculate position
        if (dash[f][s].equals("")) { //check if this spot is free, another way return false
            dash[f][s] = player ? "0" : "x";
            return true;
        } else {
            System.out.println(player!=true?"Try more":"");
            return false;
        }
    }

    /**
     * This procedure draw dashboard
     */
    public void draw() {

        int i = 0;
        int k = 0;
        for (i = 0; i < 3; i++) {
            for (k = 0; k < 3; k++) {

                if (k == 2) {

                    if (!dash[i][k].equals("")) {//check if this spot is free

                        if (i != 2) // check if its spot is last. We have to drow another line in last spots
                            System.out.print(dash[i][k] + "_");
                        else
                            System.out.print(dash[i][k] + "  ");
                    } else {
                        if (i != 2)
                            System.out.print("__");


                    }
                    continue;
                }


                if (!dash[i][k].equals("")) {

                    if (i != 2)
                        System.out.print(dash[i][k] + "_|");
                    else System.out.print(dash[i][k] + " |");


                } else {
                    if (i != 2)
                        System.out.print("__|");
                    else {
                        System.out.print("  |");
                    }

                }


            }

            System.out.println();


            k = 0;
        }

    }

    /**
     * Clear arrray
     */
    public void clear() {
        dash = new String[3][3];
    }

    /**
     * This procedure finde a winner
     * @return who win
     */
    public boolean analizeWin() {

        //chech if there is a diagonal line
        if ((dash[0][0].equals(dash[1][1]) && dash[1][1].equals(dash[2][2])) || (dash[0][2].equals(dash[1][1]) && dash[1][1].equals(dash[2][0]))) {
            if (dash[1][1].equals(""))//it can be diagonal line, but free spot. Here we chech it
                return false;
            winner = dash[0][0];
            return true;
        }
        for (int i = 0; i < 3; i++) {//Chech horisontal and vertical lines
            if ((dash[0][i].equals(dash[1][i]) && dash[1][i].equals(dash[2][i])) || (dash[i][0].equals(dash[i][1]) && dash[i][1].equals(dash[i][2]))) {

                if (dash[0][i].equals("")||dash[i][1].equals(""))
                    return false;

                winner = dash[0][0];
                return true;
            }
        }

        draw = true;
        for (int i = 0; i < 3; i++)
            for (int k=0;k<3; k++)
            {
                if (dash[i][k]=="")//analize if the draw
                    draw = false;

            }
        if (draw)
            return true;
        return false;
    }

    /**
     *
     * @return who win the game
     */
    public String getWinner() {


       if(winner.equals("0"))
           return "Computer win";
       else{
           if (winner.equals("x")) return "Player win";
            else return "Darw";
       }


        //return winner.equals("0") ? "Computer win" : "Player win";

    }
}