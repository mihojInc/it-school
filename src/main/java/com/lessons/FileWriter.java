package com.lessons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileWriter {

    public static void write(String msg){
        String message = msg + "\n";
        File file = new File("C:\\Users\\Alina\\IdeaProjects\\it-school\\it-school_mt_2.1\\src\\main\\java\\com\\lessons\\Output");
        try {
            FileUtils.writeStringToFile(file,message,"UTF-8",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
