package src.main.java.com.lessons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws FileNotFoundException, ParseException {
        String inputCardName, inputCardHistory;
        int inputPin;
        System.out.print("Please insert your card into the ATM: ");
        Scanner s = new Scanner(System.in);
        inputCardName = s.next();
        inputCardHistory = inputCardName + "_history.txt";
        String localFilePath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\creditCards\\";
        String filePath = localFilePath + inputCardName + ".csv";
        // C:\Users\master\IdeaProjects\it-school_projectATM\src\main\java\com\lessons\creditCards
        File file = new File(filePath);
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Scanner inputSteam = new Scanner(file);
        CreditCard creditCard = new CreditCard();
        //inputSteam.next(); //ignore the head line
        while (inputSteam.hasNext()) {
            String data = inputSteam.next();
            String[] values = data.split(",");
            System.out.println(values[0]);
            System.out.println(values[5]);
            creditCard = new CreditCard(inputCardName, values[0], Double.parseDouble(values[1]), Integer.parseInt(values[2]), format.parse(values[3]), Integer.parseInt(values[4]), values[5], inputCardHistory);
            System.out.println(creditCard);
        }
        // input PIN
        System.out.println("Please enter your PIN code:");
        int iPin = s.nextInt();
        System.out.println(BankRules.isPinCorrect(creditCard.getCardPin(), iPin));
        System.out.println(creditCard.getCardValidDate());
        inputSteam.close();


        System.out.println(BankRules.isCardValidate(creditCard.getCardValidDate()));
        System.out.println(Helper.modifyString(creditCard.getCardHolderName()));
        MenuATM menuATM = MenuATM.EMPTY;
        Helper.showNenuATM();
        while (true) {
            String oper = s.next();

            //инициализация списка меню
            switch (menuATM.getName(Integer.parseInt(oper))) {
                case BALANCE:
                    System.out.println(Helper.formatBillNumber(inputCardName));
                    break;
                case WITHDRAW_MONEY:
                    try {
                        Bill billWithDraw = new Bill(inputCardName,creditCard.getCardValidDate(),creditCard.getCardHolderName(),creditCard.getCardBank(),creditCard.getCardBalance(),300);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case CHANGE_PIN:

                    break;
                case PRINT_HISTORY:
                    try {
                        Bill bill = new Bill(inputCardName,creditCard.getCardValidDate(),creditCard.getCardHolderName(),creditCard.getCardBank(),creditCard.getCardBalance());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case QUIT:
                    System.out.println("Game over");
                    return;

            }


            //BankRules.isCardValidate(creditCard.getCardValidDate());
            //   String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance());
            //    System.out.println(timeStamp );


        }
    }
}
