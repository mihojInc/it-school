package src.com.lessons;

import java.util.Scanner;

public class Main {
    /**
     * Creating a menu for working with an array of numbers
     * description of the list using the Enum method
     */

    public static void main(String[] args) {
        int it = 0; //1-й элемент массива

        MenuUser[] menu = MenuUser.values();
        for (MenuUser m : menu) {
            System.out.println(m.getDescription());
        }
        System.out.print("Сделайте свой выбор:");
        MenuUser p = MenuUser.EMPTY;
        Scanner in = new Scanner(System.in);
        ManageArray item = new ManageArray();
        while (true) {
            String oper = in.next();

            //инициализация списка меню
            switch (p.getName(Integer.parseInt(oper))) {
                case ADD_ELEMENT:
                    item.addElement(it);
                    it++;
                    break;
                case SORT_MAX:
                    item.sortMax();
                    break;
                case SORT_MIN:
                    item.sortMin();
                    break;
                case CLEAN_ARRAY:
                    item.cleanArray();
                    it = 0;
                    break;
                case QUIT:
                    System.out.println("Программа завершает свою работу!");
                    return;
            }
            if (Integer.parseInt(oper)<1 && Integer.parseInt(oper)>5) {
                System.out.println("Ошибка ввода. Повторите операцию!");
                break;
            }

        }
    }
}
