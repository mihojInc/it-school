package src.com.lessons;

import java.util.Scanner;
import java.util.Random;

public class Main {
    /**
     * Игра крестики нолики с компьютером
     */

    public static final byte FIELDSIZE = 3; //размер игрового поля
    public static String[] field = new String[FIELDSIZE * FIELDSIZE];
    public static byte PlayerNum = 0; //код игрока

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); //сканер для человекп
        Random r = new Random(); //рандом для компьютера
        FieldForm.fieldInitial(); //готовим поле
        int Tmp = 0;
        // Цикл игры
        while (!LogicGame.analiseGame()) {
            FieldForm.nextPlayer(); //Меняем игроков
            while (true) {
                System.out.println("\nХод игрока: " + FieldForm.getPlayer(PlayerNum));
                FieldForm.showField(); // Рисуем поле
                if (PlayerNum == 1) { //определяем человек или компьютер
                    System.out.print("Наберите число, куда вы хотите вставить " + (1 == PlayerNum ? "крестик" : "нолик") + ": ");
                    if (sc.hasNextInt()) {
                        Tmp = sc.nextInt();
                        if (LogicGame.validatorIn(Tmp))
                            break;
                    }
                    System.out.println("Введено неправильное число. Повторите ввод");
                    sc.next();
                } else {
                    System.out.print("Ход компьютера ... игарет " + (1 == PlayerNum ? "крестик" : "нолик") + ": ");
                    Tmp = r.nextInt(8);
                    if (LogicGame.validatorIn(Tmp))
                        break;
                    System.out.println("Компьютер выбрал занятую ячейку. Повторяется  ввод");
                }
            }
            try {
                FieldForm.putX(Tmp); // Вставляем на поле крестик или нолик
            } catch (Exception e) {
                System.out.println("Что-то пошло не так ;(");
            }
        }
        FieldForm.showField();//отрисовка поля


    }
}
