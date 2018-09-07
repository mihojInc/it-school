package src.main.java.com.lessons;

import javenue.csv.Csv;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculateMoneyAtm {
    static Integer initialFiftyHoundredHryvnas = 0;
    static Integer initialHoundredHryvnas = 0;
    static Integer initialFiftyHryvnas = 0;
    static Integer initialTenHryvnas = 0;

    static Integer fiftyHoundredHryvnas = 0;
    static Integer houndredHryvnas = 0;
    static Integer fiftyHryvnas = 0;
    static Integer tenHryvnas = 0;
    static Integer totalAmount = 0;



    public static void reRun(ATMStatus atmStatus) {

        System.out.println("Would u like to credit more money ? y/n ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if (choice.equals("y") || choice.equals("Y")) {
            getMoney(atmStatus);
        }
        if (choice.equals("n") || choice.equals("N")) {
            saveMoneyATM(initialFiftyHoundredHryvnas,initialHoundredHryvnas,initialFiftyHryvnas,initialTenHryvnas );
            System.exit(1);
        } else {

            System.out.println("Invalid Input");
        }
        reRun(atmStatus);
    }

    public static void getMoney(ATMStatus atmStatus) {
        fiftyHoundredHryvnas = 0;
        houndredHryvnas = 0;
        fiftyHryvnas = 0;
        tenHryvnas = 0;
        totalAmount = 0;
        Integer amountInt = 0;
        System.out.println("Currency Avaialbe in ATM");
        for (String key : atmStatus.getAvaialableMoney().keySet()) {
            System.out.println(atmStatus.getAvaialableMoney().get(key) + ":"
                    + key + " Notes");
        }

        for (String key : atmStatus.getAvaialableMoney().keySet()) {
            if (key.equals("500"))
                initialFiftyHoundredHryvnas = atmStatus.getAvaialableMoney().get(key);
            if (key.equals("100"))
                initialHoundredHryvnas = atmStatus.getAvaialableMoney().get(key);
            if (key.equals("50"))
                initialFiftyHryvnas = atmStatus.getAvaialableMoney().get(key);
            if (key.equals("10"))
                initialTenHryvnas = atmStatus.getAvaialableMoney().get(key);
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Money > ");
        String amount = input.nextLine();
        try {
            try {
                amountInt = Integer.parseInt(amount);
                if (amountInt % 10 != 0) {
                    System.out.println("Please enter amount in multiple of 10 ");
                    reRun(atmStatus);
                }
            } catch (NumberFormatException ne) {

            }
            System.out.print("Required Amount : ");
            System.out.println(amount);

            totalAmount = ((initialFiftyHoundredHryvnas * 500) + (initialHoundredHryvnas * 100)
                    + (initialFiftyHryvnas * 50) + (initialTenHryvnas * 10));
            System.out
                    .println("Total Available amount in ATM : " + totalAmount);
            if (totalAmount < amountInt) {
                System.out
                        .println("Total Avaialble amount is less in atm, Sorry for Inconvience");
                reRun(atmStatus);
            }

            // алгоритм набора купюр из кассет

            while (amountInt >= 500 && initialFiftyHoundredHryvnas > 0) {
                initialFiftyHoundredHryvnas = initialFiftyHoundredHryvnas - 1;
                fiftyHoundredHryvnas++;
                amountInt = amountInt - 500;
            }

            while (amountInt >= 100 && initialHoundredHryvnas > 0) {
                initialHoundredHryvnas = initialHoundredHryvnas - 1;
                houndredHryvnas++;
                amountInt = amountInt - 100;
            }

            while (amountInt >= 50 && initialFiftyHryvnas > 0) {
                initialFiftyHryvnas = initialFiftyHryvnas - 1;
                fiftyHryvnas++;
                amountInt = amountInt - 50;
            }
            while (amountInt >= 10 && initialTenHryvnas > 0) {
                initialTenHryvnas = initialTenHryvnas - 1;
                tenHryvnas++;
                amountInt = amountInt - 10;
            }
            if (amountInt > 0) {
                System.out.println("No avalable balance in this unit");
                reRun(atmStatus);
            } else {
                System.out.println("Plz take your money in currency");
                Map<String, Integer> avaialableMoney = new HashMap<String, Integer>();
                System.out.println("     No of 500:" + fiftyHoundredHryvnas);
                System.out.println("     No of 100:" + houndredHryvnas);
                System.out.println("     No of 50:" + fiftyHryvnas);
                System.out.println("     No of 10:" + tenHryvnas);
                avaialableMoney.put("500", (initialFiftyHoundredHryvnas));
                avaialableMoney.put("100", (initialHoundredHryvnas));
                avaialableMoney.put("50", (initialFiftyHryvnas));
                avaialableMoney.put("10", (initialTenHryvnas));
                atmStatus.setAvaialableMoney(avaialableMoney);
            }
            //return amountInt;
        } catch (Exception e) {

        }
        System.out.println("Take your Amount = " + (500 * fiftyHoundredHryvnas + 100 * houndredHryvnas + 50 * fiftyHryvnas + 10 * tenHryvnas));
        reRun(atmStatus);


    }

    public static void saveMoneyATM(int cass1, int cass2, int cass3, int cass4){
        String filename = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\templates\\ATMDispenser.csv";
        Csv.Writer writer = new Csv.Writer(filename).delimiter(',');
        writer
                .value("500UAH").value(String.valueOf(cass1)).newLine()
                .value("100UAH").value(String.valueOf(cass2)).newLine()
                .value("50UAH").value(String.valueOf(cass3)).newLine()
                .value("10UAH").value(String.valueOf(cass4)).newLine()
                .flush()
                .close();
    }
}
