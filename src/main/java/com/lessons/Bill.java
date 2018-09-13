package src.main.java.com.lessons;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

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

    public static final com.itextpdf.text.Font FONT = new com.itextpdf.text.Font(Font.FontFamily.COURIER, 12, Font.BOLD, GrayColor.GRAYWHITE);
    public static final com.itextpdf.text.Font NUMFONT = new com.itextpdf.text.Font(Font.FontFamily.COURIER, 11, Font.BOLD, GrayColor.GRAYWHITE);
    public static final com.itextpdf.text.Font DATEFONT = new com.itextpdf.text.Font(Font.FontFamily.COURIER, 8, Font.BOLD, GrayColor.GRAYWHITE);
    public static final String MAESTRO = "D:\\Java\\library\\bank\\maestro.png";

    // bill#1 account state request
    public Bill(String billNumber, Date billDateTransaction, String billCardHolder, String billBankName, double billSum) throws IOException {
        this.billDateTransaction = billDateTransaction;
        this.billCardHolder = billCardHolder;
        this.billBankName = billBankName;
        this.billSum = billSum;
        this.billNumber = billNumber;
        History.saveUserHistory(billNumber, "user check account");
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
        writer.print("* Date: " + billDate + "               ");
        writer.println("transaction# " + Helper.formatNumTransaction(Helper.formatBillNumber(billNumber)) + " *");
        writer.println("*                                                    *");
        writer.println("*                                                    *");
        writer.println("*                                                    *");
        writer.println("*                                                    *");
        writer.println("******************************************************");
        writer.println("Your current account balance: " + billSum + " UAH");
        writer.println("******************************************************");
        writer.println("Bank contact information: phone/fax " + Helper.getPhone(billBankName));
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
        writer.println("|               № " + Helper.formatNumTransaction(Helper.formatBillNumber(billNumber)) + "                  | ");
        //     writer.print(Helper.modifyString(billBankName));
        writer.println("===========================================");

        SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String billDate = dataFormat.format(System.currentTimeMillis());
        writer.println("|      * Date: " + billDate + " *      |");
        writer.println("===========================================");
        writer.println("Your withdrawal amount: " + iAmount + " uah");
        writer.println("New balance of your account: " + billSum + " uah");
        writer.println();
        writer.println();
        writer.println();
        writer.println();
        writer.println("-------------------------------------------");
        writer.println("Contact information of the serving bank:");
        writer.println("Adress: " + Helper.getAdress(billBankName));
        writer.println("phone/fax: " + Helper.getPhone(billBankName));
        writer.println("-------------------------------------------");
        writer.println(Helper.modifyString(billCardHolder) + " :           _______ sign");
        writer.println();
        writer.flush();
        writer.close();
    }


    public static void printHistoryUser(String userCard) throws IOException, DocumentException {
        String filePath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\usersHistory\\";
        String filename = filePath + userCard + "_history.txt";
        String filePathPDF = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\printForms\\";
        String filenamePDF = filePathPDF + userCard + "_history.pdf";

        pdfHistoryCreater(filenamePDF);
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pdfHistoryCreater(String filenamePDF) throws IOException, DocumentException {
        File file = new File(filenamePDF);
        file.getParentFile().mkdirs();
        createPdf(filenamePDF);
    }

    public static void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document(PageSize.A6);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfContentByte cb = writer.getDirectContentUnder();
        document.add(getWatermarkedImage(cb, Image.getInstance(MAESTRO),
                "MR TARAS SEMENOV", FONT, 140, 15,
                "4146 0000 0000 0020", NUMFONT, 150, 50,
                "09/20", DATEFONT,125, 30));


        document.close();
    }

    public static Image getWatermarkedImage(PdfContentByte cb, Image img, String watermark, Font font, float corX, float corY,
                                            String numWatermark, Font numFont, float corXnum, float corYnum, String dateWatermark, Font dateFont, float corXdate, float corYdate) throws DocumentException {
        float width = img.getScaledWidth();
        float height = img.getScaledHeight();

        PdfTemplate template = cb.createTemplate(width, height);
        template.addImage(img, width, 0, 0, height, 0, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_RIGHT,
                new Phrase(watermark, font), corX, corY, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_RIGHT,
                new Phrase(numWatermark, numFont), corXnum, corYnum, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_RIGHT,
                new Phrase(dateWatermark, dateFont), corXdate, corYdate, 0);
        return Image.getInstance(template);
    }
}
