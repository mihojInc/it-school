package com.lessons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    static File newf = new File("C:\\Users\\Alina\\IdeaProjects\\it-school\\it-school_16\\src\\main\\java\\com\\lessons\\LinksForDownload.txt");
    static List<String> readMyFile(){
        List<String> tasks = new ArrayList<>();
        try {
            tasks = FileUtils.readLines(newf, "UTF-8");
        } catch (IOException e) {
            System.out.println("Sorry, but I can't find source file");
            System.out.println("Check it and try again");
        }
        return tasks;
    }

    public static void clear(){
        if(newf.exists()){
            try {
                FileUtils.forceDelete(newf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
