package src.com.lessons;

import java.util.Arrays;
import java.util.Scanner;

public class ManageArray {
    /**
     * create a class for managing an array
     */

    int[] masA = new int[1]; //инициализация минимального массива


    public int addElement(int it) {


        System.out.println("Добавляем число:");
        Scanner s = new Scanner(System.in);
        String chislo = s.next();
        if (it == 0) {
            masA[it] = Integer.parseInt(chislo); //1-е добавление
        } else {
            masA = Arrays.copyOf(masA, it + 1); //растягиваем массив до нужной длинны
            masA[it] = Integer.parseInt(chislo);
        }


        printDialog();

        return it;
    }

    public void sortMax() { //примитивная сортировка и перепись массива наоборот
        printDialog();
        System.out.println();
        System.out.println("Сортируем убыванием....");
        Arrays.sort(masA);
        int i, tmp, hLenght = masA.length;
        for (i = 0; i < hLenght / 2; ++i) {
            tmp = masA[i];
            masA[i] = masA[masA.length - i - 1];
            masA[masA.length - i - 1] = tmp;
        }
        printArray(masA);


    }

    public void sortMin() { //сортировка примитивным методом Arrays.sort
        printDialog();
        System.out.println();
        System.out.println("Сортируем возрастанием....");
        Arrays.sort(masA);
        printArray(masA);

    }

    public void cleanArray() {
        System.out.println("Очистка массива ...");


        int[] masB = new int[1]; //переинициализация массива
        masA = masB;
        printDialog();



    }

    public void printDialog() {
        System.out.println("------------------------");

        MenuUser[] menu = MenuUser.values(); //циклическй вывод меню
        for (MenuUser m : menu) {
            System.out.println(m.getDescription());
        }
        printArray(masA);
        System.out.print("Сделайте свой выбор:");
    }

    public void printArray(int[] myArray) { //печать текущего состояния массива
        System.out.print("Результат: ");
        for (int v : myArray) {
            System.out.print(v + " ");

        }
        System.out.println();
    }
}

