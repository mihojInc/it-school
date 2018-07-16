package com.lessons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

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
        try {
            FileUtils.forceDelete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
