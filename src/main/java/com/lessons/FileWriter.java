package com.lessons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWriter {
    static File file = new File("C:\\Users\\Alina\\IdeaProjects\\it-school\\it-school_mt_2.1\\src\\main\\java\\com\\lessons\\Output");
    public static void write(String msg){
        String message = msg + "\n";
        try {
            FileUtils.writeStringToFile(file,message,"UTF-8",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void clear(){
        if(file.exists()){
        try {
            FileUtils.forceDelete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
    public static void finalStat(){
        String report="";
        try {
            report = FileUtils.readFileToString(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher matcher1 = Pattern.compile("(?=(Producer of milk))").matcher(report);
        int match1=0;
        while (matcher1.find())
        {
           match1++;
        }
        try {
            FileUtils.writeStringToFile(file, " Milk produced:","UTF-8",true);
            FileUtils.writeStringToFile(file, String.valueOf(match1),"UTF-8",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher matcher2 = Pattern.compile("(?=(Producer of meat))").matcher(report);
        int match2=0;
        while (matcher2.find())
        {
            match2++;
        }
        try {
            FileUtils.writeStringToFile(file, " Meat produced:","UTF-8",true);
            FileUtils.writeStringToFile(file, String.valueOf(match2),"UTF-8",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher matcher3 = Pattern.compile("(?=(Producer of fish))").matcher(report);
        int match3=0;
        while (matcher3.find())
        {
            match3++;
        }
        try {
            FileUtils.writeStringToFile(file, " Fish produced:","UTF-8",true);
            FileUtils.writeStringToFile(file, String.valueOf(match3),"UTF-8",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher matcher4 = Pattern.compile("(?=(buy milk))").matcher(report);
        int match4=0;
        while (matcher4.find())
        {
            match4++;
        }
        try {
            FileUtils.writeStringToFile(file, " Milk bought:","UTF-8",true);
            FileUtils.writeStringToFile(file, String.valueOf(match4),"UTF-8",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher matcher5 = Pattern.compile("(?=(buy meat))").matcher(report);
        int match5=0;
        while (matcher5.find())
        {
            match5++;
        }
        try {
            FileUtils.writeStringToFile(file, " Meat bought:","UTF-8",true);
            FileUtils.writeStringToFile(file, String.valueOf(match5),"UTF-8",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher matcher6 = Pattern.compile("(?=(buy fish))").matcher(report);
        int match6=0;
        while (matcher6.find())
        {
            match6++;
        }
        try {
            FileUtils.writeStringToFile(file, " Fish bought:","UTF-8",true);
            FileUtils.writeStringToFile(file, String.valueOf(match6),"UTF-8",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
