package com.lessons;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

    /**
     * Method of obtaining a file
     * @param path
     * @return
     */
    public static File getFile(String path) {
        File file = new File(path);
        if (file.isFile()) {
            System.out.println("File path: " + file.getPath());
            return file;
        } else {
            System.out.println("File not found!");
        }
        return null;
    }

    /**
     * The method that gets the list of files from the directory
     * @param directory - accept directory
     * @return - list of files through Arrays.asList(file.listFiles())
     */
    public static List<File> getFiles(String directory) {
        File file = new File(directory);
        if (file.exists() && file.isDirectory()) {
            return Arrays.asList(file.listFiles());
        } else {
            System.out.println("Directory is missing!");
        }
        return null;
    }

    /**
     * List of strings in the directory
     * @param dirPath
     * @return
     */
    public static List<String> listFileFromDir(String dirPath) {
        File file = new File(dirPath);
        if (file.exists()) {
            return Arrays.asList(file.list());
        } else {
            System.out.println("Files is missing!");
        }
        return null;
    }

    /**
     * The method that reads from the file
     * @param file - accepts the input file
     * @return - text from file
     */
    public static List<String> readFile(File file) {
        List<String> stringList = new ArrayList<>();
        //Поток закрывается автоматически без метода flush()
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringList.add(string);
                System.out.println(string);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    /**
     * Method for writing text to a file
     * @param file - accepts the input file
     * @param text - list of text
     */
    public static void writeFile(File file, List<String> text) {
        //Поток закрывается автоматически без метода flush()
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            if(file.exists()){
                for (String string : text) {
                    bufferedWriter.write(string + "\n");
                }
                System.out.println("Recording was successful!");
            }else {
                System.out.println("File not found! The recording didn't work!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method that writes a stream of bytes to a file
     * @param file - accepts the input file
     * @param textBytes - array of bytes
     */
    public static void writeFile(File file, byte[] textBytes) {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            if(file.exists()){
                bufferedOutputStream.write(textBytes);
                System.out.println("Write the byte stream successfully!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found! The byte stream is not completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}