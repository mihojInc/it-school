package src.main.java.com.lessons;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Bill {
    String billNumber;
    Date billDateTransaction;
    String billCardHolder;
    String billBankName;
    double billSum;
    double iAmount;
    // bill#1 account state request
    public Bill(String billNumber,  Date billDateTransaction, String billCardHolder, String billBankName, double billSum) throws IOException {
        this.billDateTransaction = billDateTransaction;
        this.billCardHolder = billCardHolder;
        this.billBankName = billBankName;
        this.billSum = billSum;
        this.billNumber = billNumber;
        History.saveUserHistory(billNumber,"user check account");
        String localFilePath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\bills\\";
        String filePath = localFilePath + Helper.formatBillNumber(billNumber) + ".txt";

        File billFile = new File(filePath);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(billFile, true)));
        writer.println("******************************************************");
        writer.print("               *  ");
        writer.print(Helper.modifyString(billBankName));
        writer.println("  *");
        writer.println("******************************************************");
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        String billDate = dataFormat.format(System.currentTimeMillis());
        writer.print("* Date: "+billDate+"               ");
        writer.println("transaction# "+Helper.formatNumTransaction(Helper.formatBillNumber(billNumber))+" *");
        writer.println("*                                                    *");
        writer.println("*                                                    *");
        writer.println("*                                                    *");
        writer.println("*                                                    *");
        writer.println("******************************************************");
        writer.println("Your current account balance: "+billSum+ " UAH");
        writer.println("******************************************************");
        writer.println("Bank contact information: phone/fax "+Helper.getPhone(billBankName));
        writer.flush();
        writer.close();

    }
    // bill#2 if there was a withdrawal of cash
    public Bill(String billNumber, Date billDateTransaction, String billCardHolder, String billBankName, double billSum, double iAmount) throws IOException {
        this.billNumber = billNumber;
        this.billDateTransaction = billDateTransaction;
        this.billCardHolder = billCardHolder;
        this.billBankName = billBankName;
        this.billSum = billSum;
        this.iAmount = iAmount;

        String localFilePath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\bills\\";
        String filePath = localFilePath + Helper.formatBillNumber(billNumber) + ".txt";

        File billFile = new File(filePath);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(billFile, true)));
        writer.println("===========================================");
        writer.println("|       Cheque ATM cash transaction:      |");
        writer.println("|               № "+Helper.formatNumTransaction(Helper.formatBillNumber(billNumber))+"                  | ");
   //     writer.print(Helper.modifyString(billBankName));
        writer.println("===========================================");

        SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String billDate = dataFormat.format(System.currentTimeMillis());
        writer.println("|      * Date: "+billDate+" *      |");
        writer.println("===========================================");
        writer.println("Your withdrawal amount: "+iAmount+" uah");
        writer.println("New balance of your account: "+billSum+" uah");
        writer.println();
        writer.println();
        writer.println();
        writer.println();
        writer.println("-------------------------------------------");
        writer.println("Contact information of the serving bank:");
        writer.println("Adress: "+Helper.getAdress(billBankName));
        writer.println("phone/fax: "+Helper.getPhone(billBankName));
        writer.println("-------------------------------------------");
        writer.println(Helper.modifyString(billCardHolder)+" :           _______ sign");
        writer.println();
        writer.flush();
        writer.close();
    }
}
