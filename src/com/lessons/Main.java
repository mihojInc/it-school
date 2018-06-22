package com.lessons;

import java.util.Scanner;
import java.util.Random;

public class Main {

    // Размер игровово поля
    private static final byte PoleSize = 3;
    // Задаем одномерным массивом 3 на 3 поле
    private static String[] pole = new String[PoleSize * PoleSize];

    private static byte PlayerNum = 0; //код игрока

    public static void main(String[] args) throws Exception {
        int Tmp = 0;
        Scanner sc = new Scanner(System.in); //сканер для человекп
        Random r = new Random(); //рандом для компьютера

        // Инициализация поля
        for (int i = 0; i < PoleSize * PoleSize; i++) {
            pole[i] = Integer.toString(Tmp);
            Tmp++;
        }

        // Цикл игры
        while (!analiseGame()) {
            nextPlayer(); //Меняем игроков
            while (true) {
                System.out.println("\nХод игрока: " + getPlayer(PlayerNum));
                showPole(); // Рисуем поле
                if (PlayerNum == 1) { //определяем человек или компьютер
                    System.out.print("Наберите число, куда вы хотите вставить " + (1 == PlayerNum ? "крестик" : "нолик") + ": ");
                    if (sc.hasNextInt()) {
                        Tmp = sc.nextInt();
                        if (validatorIn(Tmp))
                            break;
                    }
                    System.out.println("Введено неправильное число. Повторите ввод");
                    sc.next();
                } else {
                    System.out.print("Ход компьютера ... игарет " + (1 == PlayerNum ? "крестик" : "нолик") + ": ");
                    Tmp = r.nextInt(8);
                    if (validatorIn(Tmp))
                        break;
                    System.out.println("Компьютер выбрал занятую ячейку. Повторяется  ввод");
                }
            }
            try {
                putX(Tmp); // Вставляем на поле крестик или нолик
            } catch (Exception e) {
                System.out.println("Что-то пошло не так ;(");
            }
        }
        showPole();
    }

    /**
     * Проверяем корректность ввода
     */
    private static boolean validatorIn(int iIn) {
        if (iIn >= PoleSize * PoleSize) return false;
        if (iIn < 0) return false;
        switch (getX(iIn)) {
            case 'O':
            case 'X':
                return false;
        }

        return true;
    }

    /**
     * Задаем номер следующего игрока
     */
    private static void nextPlayer() {
        PlayerNum = (byte) (1 == PlayerNum ? 2 : 1);
    }

    /**
     * Анализируем после каждой итерации:
     * 1) Победа крестиков
     * 2) Победа ноликов
     * 3) Закончились ходы
     */
    private static boolean analiseGame() {
        int i, j;
        boolean RowWin = false, ColWin = false;

        // 1.Проверка победы на колонках и столбиках
        for (i = 0; i < PoleSize; i++) {
            RowWin = true;
            ColWin = true;
            for (j = 0; j < PoleSize - 1; j++) {
                RowWin &= (getXY(i, j).charAt(0) == getXY(i, j + 1).charAt(0));
                ColWin &= (getXY(j, i).charAt(0) == getXY(j + 1, i).charAt(0));
            }
            if (ColWin || RowWin) {
                System.out.println("Победитель: " + getPlayer(PlayerNum) + "!!!");
                return true;
            }
        }

        // 2.Проверка победы по диагоналям
        RowWin = true;
        ColWin = true;
        for (i = 0; i < PoleSize - 1; i++) {
            RowWin &= (getXY(i, i).charAt(0) == getXY(i + 1, i + 1).charAt(0));
            ColWin &= (getXY(i, PoleSize - i - 1).charAt(0) == getXY(i + 1, PoleSize - i - 2).charAt(0));
        }
        if (ColWin || RowWin) {
            System.out.println("Победитель: " + getPlayer(PlayerNum) + "!!!");
            return true;
        }

        // 3.Проверка существования новых ходов
        for (i = 0; i < PoleSize * PoleSize; i++) {
            switch (getX(i)) {
                case 'O':
                case 'X':
                    break;
                default:
                    return false;
            }
        }
        if (PoleSize * PoleSize <= i) {
            System.out.println("Ничья. Кончились ходы.");
            return true;
        }

        // Игра продолжается
        return false;
    }

    /**
     * Получает значение координаты на поле
     */
    private static String getXY(int x, int y) {
        return pole[x * PoleSize + y];
    }

    /**
     * Получает значение ячейки
     */
    private static char getX(int x) {
        return pole[x].charAt(0);
    }

    /**
     * Вставляет на поле крестик или нолик
     */
    private static void putX(int x) {
        pole[x] = 1 == PlayerNum ? "X" : "O";
    }

    /**
     * Вывести игровое поле
     */
    private static void showPole() {
        for (int i = 0; i < PoleSize; i++) {
            for (int j = 0; j < PoleSize; j++) {
                if (j < PoleSize - 1) {
                    System.out.printf("%4s", getXY(i, j) + " |");
                } else {
                    System.out.print(" " + getXY(i, j));
                }
            }

            if (i < PoleSize - 1) {
                System.out.print("\n" + "-----------");
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     *Определяем кто есть кто
     */
    private static String getPlayer(byte p) {
        String player = 1 == p ? "Вы" : "Компьютер";
        return player;
    }

}
