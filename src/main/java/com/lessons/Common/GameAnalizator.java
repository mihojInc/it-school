package com.lessons.Common;

public class GameAnalizator {
    /**
     * if its figure can make step
     *
     * @param statment current statmenp of game
     * @return if this figure can make step, return this figure, if no - return figure wich must to bit
     */
    public static Figure availableFigureForStep(Statment statment,int x_old, int y_old, int x, int y) {
        if (statment.getFig(x, y).getColor() == statment.getCurPlayer()//цвет ячейки которую выбрали, соответствет цвету игрока
                && haveFigureForBit(statment, statment.getFig(x, y)) == null //нет фигур которые должны обязательно бить
                && haveFigureStep(statment,x_old,y_old, x, y))
            return statment.getFig(x, y);
        else return null;
    }

    /**
     * if on the boar have figure wich must bit another figure
     *
     * @param statment
     * @return if dash have figure winch must to bit return this one figure, else return null
     */
    public static Figure haveFigureForBit(Statment statment, Figure figure) {
        int sign = statment.getCurPlayer() == Colors.WHITE ? -1 : 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; i++) {

                if (statment.getFig(i, j) != figure)//если это текуща фигура продолжаем бе анализа

                    if (statment.getCurPlayer() == Colors.WHITE) {//если цвет белый анализируем вниз

                        if (statment.getFig(i, j).getColor() == statment.getCurPlayer()) {//выбрали нужный цвет?

                            if (((statment.getFig(i + 1, j + 1).getColor() != statment.getCurPlayer()) && //ячейка по диагонали ячейка противкника
                                    (statment.getFig(i + 2, j + 2).getColor() == Colors.EMPTY)) || //и ячейка по диагонали пустая
                                        ((statment.getFig(i + 1, j - 1).getColor() != statment.getCurPlayer())&&
                                            (statment.getFig(i + 2, j - 2).getColor() == Colors.EMPTY))){
                                return statment.getFig(i, j);//возвращаем фигуру которая может бить
                            }
                        } else return null;
                    } else {//если цвет черный анализируем вверх
                            if (statment.getFig(i, j).getColor() == statment.getCurPlayer()) {//выбрали нужный цвет?
                                if ((statment.getFig(i - 1, j - 1).getColor() != statment.getCurPlayer() &&  //ячейка по диагонали ячейка противкника
                                        (statment.getFig(i - 2, j - 2).getColor() == Colors.EMPTY)) || //и ячейка по диагонали через одну пустая
                                        ((statment.getFig(i - 1, j + 1).getColor() != statment.getCurPlayer())
                                                && (statment.getFig(i - 2, j + 2)).getColor() == Colors.EMPTY)){
                                    return statment.getFig(i, j);//возвращаем фигуру которая может бить

                                }
                            } else return null;

                    }
            }
        }
        return null;
    }

    /**
     * procedure check if figure can make step
     *
     * @param statment
     * @param x
     * @param y
     * @return
     */
    public static boolean haveFigureStep(Statment statment, int x_old, int y_old, int x_new, int y_new) {

//        if (statment.getCurPlayer() == Colors.WHITE) {
//            if (((statment.getFig(x_new - 1, y_new - 1).getColor() != statment.getCurPlayer()) &&  //ячейка по диагонали ячейка противкника
//                    (statment.getFig(x_new, y_new).getColor() == Colors.EMPTY) &&
//                    statment.getFig(x_new-2, y_new-2)==statment.getFig(x_old, y_old))
//                    ||//и ячейка по диагонали пустая
//                    (((statment.getFig(x_new - 1, y_new - 1).getColor() != statment.getCurPlayer()) &&  //ячейка по диагонали ячейка противкника
//                            (statment.getFig(x_new, y_new).getColor() == Colors.EMPTY) &&
//                            statment.getFig(x_new-2, y_new-2)==statment.getFig(x_old, y_old))) {
//                return true;//есть ход
//            }
//            if (statment.getFig(x + 1, y + 1).getColor() == Colors.EMPTY || statment.getFig(x + 1, y - 1).
//                    getColor() == Colors.EMPTY) {
//                return true;
//            }
//            return false;
//        }
//
//        if (statment.getFig(x, y).getColor() == statment.getCurPlayer()) {//выбрали нужный цвет?
//            if ((statment.getFig(x - 1, y - 1).getColor() != statment.getCurPlayer() &&  //ячейка по диагонали ячейка противкника
//                    (statment.getFig(x - 2, y - 2).getColor() == Colors.EMPTY)) || //и ячейка по диагонали через одну пустая
//                    ((statment.getFig(x - 1, y + 1).getColor() != statment.getCurPlayer())
//                            && (statment.getFig(x- 2, y + 2)).getColor() == Colors.EMPTY)){
//                return true;//есть ход
//            }
//            if (statment.getFig(x - 1, y - 1).getColor() == Colors.EMPTY || statment.getFig(x - 1, y + 1).
//                    getColor() == Colors.EMPTY) {
//                return true;
//            }
//        }
//
//        return false;
//    }

//
//        if (statment.getCurPlayer() == Colors.WHITE) {
//            if (((statment.getFig(x + 1, y + 1).getColor() != statment.getCurPlayer()) &&  //ячейка по диагонали ячейка противкника
//                    (statment.getFig(x + 2, y + 2).getColor() == Colors.EMPTY)) ||//и ячейка по диагонали пустая
//                    ((statment.getFig(x + 1, y - 1).getColor() != statment.getCurPlayer())
//                            && (statment.getFig(x + 2, y - 2).getColor() == Colors.EMPTY))) {
//                return true;//есть ход
//            }
//            if (statment.getFig(x + 1, y + 1).getColor() == Colors.EMPTY || statment.getFig(x + 1, y - 1).
//                    getColor() == Colors.EMPTY) {
//                return true;
//            }
//            return false;
//        }
//
//        if (statment.getFig(x, y).getColor() == statment.getCurPlayer()) {//выбрали нужный цвет?
//            if ((statment.getFig(x - 1, y - 1).getColor() != statment.getCurPlayer() &&  //ячейка по диагонали ячейка противкника
//                    (statment.getFig(x - 2, y - 2).getColor() == Colors.EMPTY)) || //и ячейка по диагонали через одну пустая
//                    ((statment.getFig(x - 1, y + 1).getColor() != statment.getCurPlayer())
//                            && (statment.getFig(x- 2, y + 2)).getColor() == Colors.EMPTY)){
//                return true;//есть ход
//            }
//            if (statment.getFig(x - 1, y - 1).getColor() == Colors.EMPTY || statment.getFig(x - 1, y + 1).
//                    getColor() == Colors.EMPTY) {
//                return true;
//            }
//        }
//
       return true;
    }
}