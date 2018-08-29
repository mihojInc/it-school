package src.main.java.com.lessons;

import java.util.Date;

public class BankRules {
   public static boolean isCardValidate(Date checkDate){
       Date curDate = new Date();
        if (checkDate.getTime() >= curDate.getTime()) {
            return true;
        }
        return false;
    }

    public static boolean isPinCorrect(int pinCard, int ipinCard){
        if (pinCard==ipinCard) {
            return true;
        }
        return false;
    }

    public static boolean isBalanceAviable(double cardBalance, double iAmount){
        if (cardBalance >= iAmount) {
            return true;
        }
        return false;
    }
}
