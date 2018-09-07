package src.main.java.com.lessons;

import java.io.*;
import java.text.SimpleDateFormat;

public class History {

    public static void saveUserHistory(String cardName, String userOperation) {
        String localFilePath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\usersHistory\\";
        String filePath = localFilePath + cardName + "_history.txt";
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String operationDate = dataFormat.format(System.currentTimeMillis());

        File billFile = new File(filePath);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(billFile, true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println(operationDate + " " + userOperation);
        writer.flush();
        writer.close();
    }
}
