package com.lessons.Common;

import java.io.Serializable;

/**
 * class describe every figure on the dashdoard. Their posirion and current statment
 */
public class Figure implements Serializable {

    /**
     * Position of fii]gure on the DashBoard
     */
    private int posV;
    private int posG;
    private Colors color;

    public int getPosV() {
        return posV;
    }

    public int getPosG() {
        return posG;
    }

    public Figure(int posV, int posG, Colors color) {
        this.posV = posV;
        this.posG = posG;
        this.queen = false;
        this.color = color;
    }

    /**
     * If this figure is already queen
     */
    boolean queen = false;

    public boolean isQueen() {
        return queen;
    }

    public void setQueen(boolean queen) {
        this.queen = queen;
    }

    /**
     * Устанавливает новые координаты для фигура
     * @param x
     * @param y
     */
    public void setCoord(int x, int y){
        posG = x;
        posV = y;
        if (x==7){
            setQueen(true);
        }
    }

    /**
     * проверяет равен ли текущий элемент или нет
     * @param x
     * @param y
     * @return
     */
    public boolean equals(int x, int y) {
        if (posV==x&&posG==y) {
            return true;
        }
        return false;
    }

    public Colors getColor() {
        return color;
    }
}
