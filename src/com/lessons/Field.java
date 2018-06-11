package com.lessons;

import java.io.IOException;
import java.util.Scanner;

/**
 * Create a class Field
 */
public class Field {
    //Create a two-dimensional array of three by three
    public static char[][] field = {{'*', '*', '*'},
                                    {'*', '*', '*'},
                                    {'*', '*', '*'}};

    /**
     * The method in which the user makes a move
     *
     * @param scanner
     * @throws IOException
     */
    public void playerMove(Scanner scanner) throws IOException {
        //Координаты x, y
        int x, y;
        System.out.print("Введите число по горизонтали \"X\" от (0...2):");
        y = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите число по вертикали \"Y\" от (0...2):");
        x = Integer.parseInt(scanner.nextLine());
        //Проверяем в цикле с предусловием во-первых, не попал ли ход игрока на уже занятое поле,
        //во-вторых, не выходят ли введенные пользователем цифры за границы нашего игрового поля.
        //Если хоть одно из этих условий не выполняется, тогда мы заново просим ввести позицию X или Y.
        //Ну а если все нормально, то цикл не выполнится и мы запишем в игровое поле ход игрока.
        while (field[x][y] == '0' || field[x][y] == 'X' || x < 0 || x > 2
                || y < 0 || y > 2) {
            System.out.print("Введите число по горизонтали \"X\" еще раз:");
            x = Integer.parseInt(scanner.nextLine()) - 1;
            System.out.print("Введите число по вертикали \"Y\" еще раз:");
            y = Integer.parseInt(scanner.nextLine()) - 1;
        }
        //Записываем в игровое поле, ход игрока.
        field[x][y] = 'X';
    }

    /**
     * The method in which the computer makes a move
     */
    public void computerMove() {
        //Math.random() создает случайное число в интервале от 0 до 2,
        //затем полученное число мы умножаем на три и округляем до целого.
        //В итоге получаем числа X и Y в интервале от нуля до двух включительно.
        int x = (int) (Math.random() * 3);
        int y = (int) (Math.random() * 3);
        //Проверяем, может ли бот сделать ход на полученные координаты,
        //и если не может, то точно так же создаем два новых числа и проверяем их.
        while (field[x][y] == 'O' || field[x][y] == 'X') {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        }
        //Записываем в игровое поле,ход компьютера
        field[x][y] = 'O';
    }

    /**
     * The method determines whether free cells remain on the playing field
     */
    public boolean freeFields() {
        boolean flag = false;
        //Проходим циклами по массиву
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //Если координаты массива соответствуют символу,
                //значит ячейка пустая.
                if (field[i][j] == '*') {
                    flag = true;
                    break;
                }
            }
            if (flag = true) {
                break;
            }
        }
        return flag;
    }

    /**
     * The method that displays the game board
     */
    public void displayField() {
        //Для того что бы вывести двухмерный массив,
        //пройдемся по массиву двумя циклами.
        //Первым циклом по строкам, а вторым по столбцам.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //Выведем на экран массив
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * The method that checks the winner
     */
    public char checkWinner() {
        char winner = ' ';
        // Проверка по горизонтали
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2]
                    && field[i][0] != '*') {
                winner = field[i][0];
                break;
            }
        }

        // Проверка по вертикали
        if (winner == ' ') {
            for (int i = 0; i < 3; i++) {
                if (field[0][i] == field[1][i] && field[1][i] == field[2][i]
                        && field[0][i] != '*') {
                    winner = field[0][i];
                    break;
                }
            }
        }

        // Проверка главной диагонали
        if (winner == ' ') {
            if (field[0][0] == field[1][1] && field[1][1] == field[2][2]
                    && field[0][0] != '*') {
                winner = field[0][0];
            }
        }

        // Проверка побочной диагонали
        if (winner == ' ') {
            if (field[0][2] == field[1][1] && field[1][1] == field[2][0]
                    && field[0][2] != '*') {
                winner = field[0][2];
            }
        }
        // Возвращаем победителя или проебл, если такового пока нет
        return winner;
    }
}
