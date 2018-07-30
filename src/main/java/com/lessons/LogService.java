package com.lessons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

public class LogService {

    static File file = new File("C:\\Users\\Alina\\IdeaProjects\\it-school\\it-school_16\\src\\main\\java\\com\\lessons\\Log.txt");

    public static void write(String msg){
            String message = msg + "\n";
            try {
                FileUtils.writeStringToFile(file,message,"UTF-8",true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
