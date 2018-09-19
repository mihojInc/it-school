package src.main.java.com.lessons;

import javafx.scene.input.DataFormat;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static String modifyString(String iStr){
        char[] chArray = iStr.toCharArray();
        for(int i = 0; i<chArray.length; i++){
            if(chArray[i] == '_'){
                chArray[i] = ' ';
            }
        }
        return String.valueOf(chArray);
    }


    public static void showNenuATM(){
        MenuATM[] menu = MenuATM.values();
        for (MenuATM m : menu) {
            System.out.println(m.getDescriptionMenu());
        }
    }

    public static String formatBillNumber(String cardNumber){
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyMMddHHmm");
        String billNumber = dataFormat.format(System.currentTimeMillis());
        return  cardNumber+billNumber;
    }

    public static String formatNumTransaction(String trans){
        String numTransaction = trans.substring(12);
        return numTransaction;
    }

    public static String getAdress(String iAdress){
        BankAdress[] adresses = BankAdress.values();
        String fullBankAdress = BankAdress.BANK_OF_AMERICA.getBankAdress();
        for (BankAdress a:adresses) {
            if (a.getBankName().equals(iAdress)){
                fullBankAdress = a.getBankAdress();
            }
        }
        return fullBankAdress;
    }

    public static String getPhone(String iPhone){
        BankAdress[] adresses = BankAdress.values();
        String bankPhone = BankAdress.BANK_OF_AMERICA.getBankPhone();
        for (BankAdress a:adresses) {
            if (a.getBankName().equals(iPhone)){
                bankPhone = a.getBankPhone();
            }
        }
        return bankPhone;
    }
    public static String formatDate(Date iDate){
        String dateToString ="";
        Format formatter = new SimpleDateFormat("dd.MM.yyyy");
        dateToString = formatter.format(iDate);
        return dateToString;
    }

    public static String formatStringName(String unName){
        String formatName ="";
        char[] chArray = unName.toCharArray();
        for(int i = 0; i<chArray.length; i++){
            if(chArray[i] == '_'){
                chArray[i] = ' ';
            }
        }
        formatName = String.valueOf(chArray);
        return formatName.toUpperCase();
    }

    public static String formatDateForCard(Date localDate){
        String dateToString ="";
        Format formatter = new SimpleDateFormat("MM/yy");
        dateToString = formatter.format(localDate);
        return dateToString;
    }

    public static String formatCardNumber(String cardNumber){
        StringBuilder stringBuilder = new StringBuilder(cardNumber.substring(0,4));
        stringBuilder.append(" 0000 0000 ");
        stringBuilder.append(cardNumber.substring(4,8));
        return String.valueOf(stringBuilder);
    }

}
