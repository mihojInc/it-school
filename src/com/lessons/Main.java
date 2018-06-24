package com.lessons;

import java.io.File;
import java.util.List;

/**
 * Lesson 9 about work with files
 */
public class Main {

    public static void main(String[] args) {

        File ourFile = FileUtil.getFile("/home/mihoj/IdeaProjects/it-school/src/com/lessons/example.txt");

        System.out.println(ourFile.getName());


        List<File> files = FileUtil.getFiles("/home/mihoj/IdeaProjects/it-school/src/com/lessons");

        for (File file : files) {
            System.out.println(file.getName());
        }

        System.out.println("--------------dir enumeration----------------");

        for (String fileName : FileUtil.listFilesFromDir("/home/mihoj/IdeaProjects/it-school/src/com/lessons")) {
            System.out.println(fileName);
        }

        //read file
        System.out.println("------read file " + ourFile.getName() + "-------------");
        List<String> content = FileUtil.readFiles(ourFile);

        for (String out : content)
            System.out.println(out);

        //write
        System.out.println("------ write file " + ourFile.getName() + "-------------");
        content.add("new any string");
        FileUtil.writeToFile(ourFile, content);
        for (String out : content)
            System.out.println(out);
        FileUtil.writeToFile(ourFile, new byte[]{0, 2, 3});
    }

}
