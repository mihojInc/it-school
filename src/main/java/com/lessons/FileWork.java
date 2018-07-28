package com.lessons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    static File file = new File("C:\\Users\\Alina\\IdeaProjects\\it-school\\annotation\\src\\main\\java\\com\\lessons\\output.txt");
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

    static List<String> readMyFile(){
        List<String> tasks = new ArrayList<>();
        try {
            tasks = FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            System.out.println("Sorry, but I can't find source file");
            System.out.println("Check it and try again");
        }
        return tasks;
    }
}
