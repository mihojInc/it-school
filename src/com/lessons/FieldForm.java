package src.com.lessons;

import static src.com.lessons.Main.FIELDSIZE;
import static src.com.lessons.Main.PlayerNum;
import static src.com.lessons.Main.field;

public class FieldForm {

    protected static void nextPlayer() {
        PlayerNum = (byte) (1 == PlayerNum ? 2 : 1);
    }

    protected static String getXY(int x, int y) {
        return field[x * FIELDSIZE + y];
    }

    /**
     * Получает значение ячейки
     */
    protected static char getX(int x) {
        return field[x].charAt(0);
    }

    /**
     * Вставляет на поле крестик или нолик
     */
    protected static void putX(int x) {
        field[x] = 1 == PlayerNum ? "X" : "O";
    }

    /**
     * Вывести игровое поле
     */
    protected static void showField() {
        for (int i = 0; i < FIELDSIZE; i++) {
            for (int j = 0; j < FIELDSIZE; j++) {
                if (j < FIELDSIZE - 1) {
                    System.out.printf("%4s", getXY(i, j) + " |");
                } else {
                    System.out.print(" " + getXY(i, j));
                }
            }

            if (i < FIELDSIZE - 1) {
                System.out.print("\n" + "-----------");
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Определяем кто есть кто
     */
    protected static String getPlayer(byte p) {
        String player = 1 == p ? "Вы" : "Компьютер";
        return player;
    }

    protected static void fieldInitial() {
        int iTmp = 0;
        for (int i = 0; i < FIELDSIZE * FIELDSIZE; i++) {
            field[i] = Integer.toString(iTmp);
            iTmp++;
        }
    }

}
