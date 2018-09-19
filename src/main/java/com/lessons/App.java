package src.main.java.com.lessons;

import com.itextpdf.text.DocumentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws IOException, ParseException, DocumentException {
        String inputCardName, inputCardHistory;
        int pinTry = 1;
        System.out.print("Please insert your card into the ATM: ");
        Scanner s = new Scanner(System.in);
        inputCardName = s.next();
        inputCardHistory = inputCardName + "_history.txt";
        String localFilePath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\creditCards\\";
        String filePath = localFilePath + inputCardName + ".csv";
        File file = new File(filePath);
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Scanner inputSteam = new Scanner(file);
        CreditCard creditCard = new CreditCard();
        while (inputSteam.hasNext()) {
            String data = inputSteam.next();
            String[] values = data.split(",");
            creditCard = new CreditCard(inputCardName, values[0], Double.parseDouble(values[1]), Integer.parseInt(values[2]), format.parse(values[3]), Integer.parseInt(values[4]), values[5], inputCardHistory);
        }
        // input PIN
        System.out.println("Please enter your PIN code:");
        int iPin = s.nextInt();

        if (BankRules.isCardValidate(creditCard.getCardValidDate())) {
            if (BankRules.isCardBlocked(creditCard.getCardBlockField())) {
                while (!BankRules.isPinIncorrect(pinTry)) {

                    if (BankRules.isPinCorrect(creditCard.getCardPin(), iPin)) {

                        inputSteam.close();
                        MenuATM menuATM = MenuATM.EMPTY;
                        Helper.showNenuATM();
                        while (true) {
                            String oper = s.next();

                            //initialize list of menu
                            switch (menuATM.getName(Integer.parseInt(oper))) {
                                case BALANCE:
                                    try {
                                        History.saveUserHistory(creditCard.getCardName(), "user check balance..");
                                        Bill bill = new Bill(inputCardName, creditCard.getCardValidDate(), creditCard.getCardHolderName(), creditCard.getCardBank(), creditCard.getCardBalance());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case WITHDRAW_MONEY:
                                    try {
                                        ATMStatus atmStatus = new ATMStatus();
                                        Double result = CalculateMoneyAtm.getMoney(atmStatus, creditCard.getCardBalance());
                                        System.out.println("Your new account balance: " + result);
                                        Double sumTransaction = creditCard.getCardBalance() - result;
                                        Bill billWithDraw = new Bill(inputCardName, creditCard.getCardValidDate(), creditCard.getCardHolderName(), creditCard.getCardBank(), result, sumTransaction);
                                        String history = "user withdrew " + sumTransaction + " UAH";
                                        History.saveUserHistory(creditCard.getCardName(), history);
                                        BankRules.setCardNewBalance(creditCard.getCardName(), creditCard.getCardHolderName(), result, creditCard.getCardPin(), creditCard.getCardValidDate(), creditCard.getCardBank());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case CHANGE_PIN:

                                    System.out.println("Please enter your old PIN code:");
                                    iPin = s.nextInt();
                                    if (BankRules.isPinCorrect(iPin, creditCard.getCardPin())) {
                                        System.out.println("Please enter new PIN code:");
                                        int iChangePin = s.nextInt();
                                        CreditCard.setNewPin(creditCard.getCardName(), creditCard.getCardHolderName(), creditCard.getCardBalance(), iChangePin, creditCard.getCardValidDate(), creditCard.getCardBank());
                                        History.saveUserHistory(creditCard.getCardName(), "user changed the pin code");
                                        System.out.println("The PIN code was changed");
                                    } else {
                                        System.out.println("You entered an incorrect pin");
                                    }

                                    break;
                                case PRINT_HISTORY:
                                    History.saveUserHistory(creditCard.getCardName(), "user print history");
                                    Bill.printHistoryUser(creditCard.getCardName(), creditCard.getCardHolderName(),creditCard.getCardValidDate());

                                    break;

                                case QUIT:
                                    System.out.println("Good buy!");
                                    return;

                            }

                        }
                    } else {
                        System.out.println("You entered an incorrect pin code, please try again!");
                        History.saveUserHistory(creditCard.getCardName(), "the user typed the wrong pin...");
                        System.out.println("Please enter your PIN code:");
                        iPin = s.nextInt();

                        if (pinTry == BankRules.PIN_TRY_BLOCKED) {
                            System.out.println("Your card is locked...");
                            BankRules.setCardBlocked(creditCard.getCardName(), creditCard.getCardHolderName(), creditCard.getCardBalance(), creditCard.getCardPin(), creditCard.getCardValidDate(), creditCard.getCardBank());
                            History.saveUserHistory(creditCard.getCardName(), "* the user has blocked his card! *");
                        }
                        pinTry++;
                    }
                }// while pinTry

            } else {
                System.out.println("Your card has blocked, please contact the bank...");
                return;
            }// "if" blocked
        } else {
            System.out.println("Your card has expired, please contact the bank...");
            return;
        }// "if" validate

    }
}
