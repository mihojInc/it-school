package com.lessons.Common;

import java.io.Serializable;

/**
 * This class describe current statment with figure arrangement
 *
 */
public class Statment implements Serializable {

    /**
     * Array wich contains current figure position on a dashboard
     */
    private Figure[][] state = new Figure[8][8];
    private Figure figure = new Figure(99,99,  Colors.EMPTY);
    private Figure unExist = new Figure(99,99,  Colors.NULL);
    /**
     * curPlayer its color current player
     */
    private Colors curPlayer = Colors.WHITE;

    /**
     * Constructor initialize base position of figure
     */
    public Statment() {
        int k;
        curPlayer = Colors.WHITE;
        for (int i = 0; i < 8; i++) {

            if ((i + 1) % 2 != 0)
                k = 0;
            else
                k = 1;
            for (; k < 8; k += 2) {
                if (i < 3) {
                    state[i][k] = new Figure(i, k, Colors.WHITE);
                }
                if (i > 4)
                    state[i][k] = new Figure(i, k, Colors.BLACK);
            }
        }


    }

    public Colors getCurPlayer() {
        return curPlayer;
    }

    public void setCurPlayer(Colors curPlayer) {
        this.curPlayer = curPlayer;
    }

    public Figure getFig(int x, int y){

        try {
            return state[x][y]==null?figure:state[x][y];
        } catch (NullPointerException e){
            return unExist;
        }catch (ArrayIndexOutOfBoundsException e){
            return unExist;
        }
    }

    /**
     *
     * @param x_old x coordinate figure wich make step
     * @param y_old y coordinate figure wich make step
     * @param x_new new x coordinte of figure
     * @param y_new new y coordinte of figure
     */
    public void makeStep(int x_old, int y_old, int x_new, int y_new) {
        try{
            if((y_new-y_old)>1){
                state[x_new-1][y_new-1] = null;
            }else{
                state[x_new-1][y_new+1] = null;
            }
            state[x_new][y_new]=state[x_old][y_old];
            state[x_old][y_old].setCoord(x_new, y_new);
            state[x_old][y_old] = null;
        }catch (NullPointerException e){
            System.out.println("Incorrect step");
        }

    }
}
