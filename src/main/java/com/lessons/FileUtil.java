package com.lessons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {
    public static void clearFile(File file){
        FileWriter fw = null;
        BufferedWriter bw = null;

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void appedToFile(File file, String str){
        FileWriter fw = null;
        BufferedWriter bw = null;

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(str);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String readString(File file, Integer count){
        FileReader fr = null;
        BufferedReader br = null;
        String result = "";

        if(!file.exists()){
            System.out.println("File does't exist");
            return result;
        }

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            List<String> strings = br.lines().collect(Collectors.toList());
            result = strings.get(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
