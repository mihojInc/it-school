package com.lessons.LogService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static void clearFile() {
        File file =  new File("");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("File in cleaning!");
        }
    }

    public static List<String> readFile() {
        File file = new File("/home/denis/Programming/it-school/src/main/java/com/lessons/LogService/ImagesURL");
        List<String> stringList = new ArrayList<>();
        String string;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((string = bufferedReader.readLine()) != null) {
                stringList.add(string);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

}
