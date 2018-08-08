package com.lessons;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileWorking {
    static DateTimeFormatter test = DateTimeFormat.forPattern("dd-MM-YYYY hh:mm a");
    static File newf = new File("C:\\Users\\Alina\\IdeaProjects\\it-school\\half_of_course_project\\src\\main\\java\\com\\lessons\\input.txt");

    static List<String> readMyFile() {
        List<String> tasks = new ArrayList<>();
        try {
            tasks = FileUtils.readLines(newf, "UTF-8");
        } catch (IOException e) {
            System.out.println("Sorry, but I can't find source file");
            System.out.println("Check it and try again");
        }
        return tasks;
    }

    public static void write(LinkedHashMap<DateTime, String> plan, DateTime day) {
        DateTimeFormatter test1 = DateTimeFormat.forPattern("hh:mm a");
        DateTimeFormatter nameOfDay = DateTimeFormat.forPattern("dd-MM-YYYY");
        String dayName = nameOfDay.print(day);
        String path = "C:\\Users\\Alina\\IdeaProjects\\it-school\\half_of_course_project\\src\\main\\java\\com\\lessons\\" + dayName;
        File file = new File(path);
        try {
            FileUtils.writeStringToFile(file, dayName+ "\n", "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set set = plan.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<DateTime, String> item = (Map.Entry) iterator.next();
            String message = test1.print(item.getKey()) + " : " + item.getValue() + "\n";
            try {
                FileUtils.writeStringToFile(file, message, "UTF-8", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void clear(File file) {
        if (file.exists()) {
            try {
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
