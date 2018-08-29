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

    public Bill(String billNumber,  Date billDateTransaction, String billCardHolder, String billBankName, double billSum) throws IOException {
        this.billDateTransaction = billDateTransaction;
        this.billCardHolder = billCardHolder;
        this.billBankName = billBankName;
        this.billSum = billSum;
        this.billNumber = billNumber;

        String localFilePath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\bills\\";
        String filePath = localFilePath + Helper.formatBillNumber(billNumber) + ".txt";

        File billFile = new File(filePath);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(billFile, true)));
        writer.println("********************");
        writer.print("* ");
        writer.print(Helper.modifyString(billBankName));
        writer.println(" *");
        writer.println("********************");
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        String billDate = dataFormat.format(System.currentTimeMillis());
        writer.print("* Date: "+billDate+"           ");
        writer.println("transaction# "+Helper.formatNumTransaction(Helper.formatBillNumber(billNumber))+" *");
        writer.flush();
        writer.close();

    }
}
