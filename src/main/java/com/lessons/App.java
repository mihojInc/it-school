package src.main.java.com.lessons;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuLoader menuLoader = MenuLoader.A;
        Loader loader = new Loader();

            while (menuLoader != menuLoader.Q) {

                switch (menuLoader) {

                    case F:
                        System.out.println("Uploading from file ...");
                        loader.fromFile();
                        break;

                    case C:
                        System.out.print("Please input path: ");
                        loader.fromConsole(scanner.nextLine());
                        break;

                    case A:
                    default:
                        menuLoader.printMenu();
                        break;
                }


                menuLoader = menuLoader.getMenuCommand(scanner.nextLine());

            }
        }

    }
