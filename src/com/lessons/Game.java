package com.lessons;
public class Game {

    private String[][] dash = new String[3][3];


    private String winner;

    public Game() {
        for(int i=0; i<3; i++)
            for(int k=0; k<3; k++)
                dash[i][k]="";
    }

    public boolean step(int pos, boolean player) {

        if(pos>8){
            return false;
        }


        int s = (pos % 3)==0?2:(pos % 3)-1;
        int f = (pos / 3);
        if (dash[s][f].equals(""))
        {
            dash[(pos % 3)-1][(int)(pos / 3)] = player ? "0" : "x";
            return true;
        }
        else{
            System.out.println("Try more");
            return false;
        }
    }


    public void draw() {

        int i =0;
        int k =0;
        for (i = 0; i < 3; i++) {
            for (k = 0; k < 3; k++) {

                if(k==2){

                    if (!dash[i][k].equals("")){

                        if(i!=2)
                        System.out.print(dash[i][k] + "_");
                        else
                            System.out.print(dash[i][k] + "  ");
                    }else {
                        if(i!=2)
                        System.out.print("__");


                    }
                    continue;
                }


                if (!dash[i][k].equals("")){

                    if(i!=2)
                    System.out.print(dash[i][k] + "_|");
                    else System.out.print(dash[i][k] + " |");


                }else {
                    if(i!=2)
                    System.out.print("__|");
                    else {
                        System.out.print("  |");
                    }
                    continue;
                }


            }

            System.out.println();


            k=0;
        }

    }

    public void clear() {
        dash = new String[3][3];
    }

    public boolean analizeWin() {


        boolean a = (dash[0][0].equals(dash[1][1])&& dash[1][1].equals(dash[2][2]));
        if (a||(dash[0][2].equals(dash[1][1])&& dash[1][1].equals(dash[2][0]))) {
            if (dash[0][2].equals(""))
                return false;
            winner = dash[0][0];
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if ((dash[0][i].equals(dash[1][i])&& dash[1][i].equals(dash[2][i]))||( dash[i][0].equals(dash[i][1]) && dash[i][1].equals(dash[i][2])) ) {

                if (dash[0][i].equals(""))
                    return false;

                winner = dash[0][0];
                return true;
            }
        }
        return false;

    }

    public String getWinner() {
        return winner;
    }
}