package src.com.lessons;


import static src.com.lessons.Main.FIELDSIZE;
import static src.com.lessons.Main.PlayerNum;


public class LogicGame {

    protected static boolean validatorIn(int iIn) {
        if (iIn >= FIELDSIZE * FIELDSIZE) return false;
        if (iIn < 0) return false;
        switch (FieldForm.getX(iIn)) {
            case 'O':
            case 'X':
                return false;
        }

        return true;
    }

    protected static boolean analiseGame() {
        int i, j;
        boolean RowWin = false, ColWin = false;

        // 1.Проверка победы на колонках и столбиках
        for (i = 0; i < FIELDSIZE; i++) {
            RowWin = true;
            ColWin = true;
            for (j = 0; j < FIELDSIZE - 1; j++) {
                RowWin &= (FieldForm.getXY(i, j).charAt(0) == FieldForm.getXY(i, j + 1).charAt(0));
                ColWin &= (FieldForm.getXY(j, i).charAt(0) == FieldForm.getXY(j + 1, i).charAt(0));
            }
            if (ColWin || RowWin) {
                System.out.println("Победитель: " + FieldForm.getPlayer(PlayerNum) + "!!!");
                return true;
            }
        }

        // 2.Проверка победы по диагоналям
        RowWin = true;
        ColWin = true;
        for (i = 0; i < FIELDSIZE - 1; i++) {
            RowWin &= (FieldForm.getXY(i, i).charAt(0) == FieldForm.getXY(i + 1, i + 1).charAt(0));
            ColWin &= (FieldForm.getXY(i, FIELDSIZE - i - 1).charAt(0) == FieldForm.getXY(i + 1, FIELDSIZE - i - 2).charAt(0));
        }
        if (ColWin || RowWin) {
            System.out.println("Победитель: " + FieldForm.getPlayer(PlayerNum) + "!!!");
            return true;
        }

        // 3.Проверка существования новых ходов
        for (i = 0; i < FIELDSIZE * FIELDSIZE; i++) {
            switch (FieldForm.getX(i)) {
                case 'O':
                case 'X':
                    break;
                default:
                    return false;
            }
        }
        if (FIELDSIZE * FIELDSIZE <= i) {
            System.out.println("Ничья. Кончились ходы.");
            return true;
        }

        // Игра продолжается
        return false;
    }
}
