package src.main.java.com.lessons;

import javenue.csv.Csv;

import java.util.Date;

public class BankRules {
    public static final int PIN_TRY_BLOCKED =3;

    public static boolean isCardValidate(Date checkDate) {
        Date curDate = new Date();
        if (checkDate.getTime() >= curDate.getTime()) {
            return true;
        }
        return false;
    }

    public static boolean isPinIncorrect(int numTry) {
        if (numTry == PIN_TRY_BLOCKED+1) {
            return true;
        }
        return false;
    }

    public static boolean isCardBlocked(int iCard) {
        if (iCard == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPinCorrect(int pinCard, int ipinCard) {
        if (pinCard == ipinCard) {
            return true;
        }
        return false;
    }

    public static boolean isBalanceAviable(double cardBalance, double iAmount) {
        if (cardBalance >= iAmount) {
            return true;
        }
        return false;
    }

    public static void setCardBlocked(String fName, String cName, Double cAmount, int cPIN, Date cDate, String cBank){
        String filePath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\creditCards\\";
        String filename = filePath+fName+".csv";
        Csv.Writer writer = new Csv.Writer(filename).delimiter(',');
        writer
                .value(cName).value(String.valueOf(cAmount)).value(String.valueOf(cPIN)).value(Helper.formatDate(cDate)).value("1").value(cBank)
                .flush()
                .close();
    }

    public static void setCardNewBalance(String bfName, String bName, Double bAmount, int bPIN, Date bDate, String bBank){
        String filePath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\creditCards\\";
        String filename = filePath+bfName+".csv";
        Csv.Writer writer = new Csv.Writer(filename).delimiter(',');
        writer
                .value(bName).value(String.valueOf(bAmount)).value(String.valueOf(bPIN)).value(Helper.formatDate(bDate)).value("0").value(bBank)
                .flush()
                .close();

    }

}
