package com.lessons;
public class Game {

    private char[][] dash = new char[3][3];


    private char winner;

    public boolean step(int pos, boolean player) {

        if(pos>8){
            return false;
        }

        if (dash[pos % 3][pos / 3]!=' ' )
        {
            dash[pos % 3][pos / 3] = player ? '0' : 'x';
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

                    if (dash[i][k]!=' '){

                        if(i!=2)
                        System.out.print(dash[i][k] + "__");
                        else
                            System.out.print(dash[i][k] + "  ");
                    }else {
                        if(i!=2)
                        System.out.print("___");


                    }
                    continue;
                }


                if (dash[i][k]!=' '){

                    if(i!=2)
                    System.out.print(dash[i][k] + "__|");
                    else System.out.print(dash[i][k] + "  |");


                }else {
                    if(i!=2)
                    System.out.print("___|");
                    else {
                        System.out.print("   |");
                    }
                    continue;
                }


            }

            System.out.println();


            k=0;
        }

    }

    public void clear() {
        dash = new char[3][3];
    }

    public boolean analizeWin() {

        if ((dash[0][0] == dash[1][1]&& dash[1][1]== dash[2][2] )|| (dash[0][2] == dash[1][1] && dash[1][1]== dash[2][0])) {
            winner = dash[0][0];
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if ((dash[0][i] == dash[1][i] && dash[1][i]== dash[2][i] )||( dash[i][0] == dash[i][1] && dash[i][1] == dash[i][2])) {
                winner = dash[0][0];
                return true;
            }


        }
        return false;

    }

    public char getWinner() {
        return winner;
    }
}