package src.main.java.com.lessons;

import javafx.scene.input.DataFormat;

import java.text.SimpleDateFormat;

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
}
