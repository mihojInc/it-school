package com.lessons;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * From easy work with files and directory
 */
public class FileUtil {

    private static FileReader fileReader;
    private static BufferedReader bufferedReader;
    private static FileOutputStream fileOutputStream;
    private static File file;

    /**
     * Get File from his path
     *
     * @param path file path
     * @return File if it exist or null
     */
    public static File getFile(String path) {
        file = new File(path);

        if (file.isFile()) {
            return file;
        }

        return null;
    }

    /**
     * From get all files in the dir
     *
     * @param dirPath absolute path to the dir
     * @return ArrayList with all present files or empty List
     */
    public static List<File> getFiles(String dirPath) {
        file = new File(dirPath);
        List<File> files = new ArrayList<>();

        if (file.isFile()) {
            files.add(file);
        } else if (file.list().length > 0) {
            for (File fileFromDirectory : file.listFiles()) {
                files.add(fileFromDirectory);
            }
        }
        return files;
    }

    /**
     * Get all names of exist files
     *
     * @param dirPath absolute path to dir
     * @return ArrayList of names by String or null if path to the file
     */
    public static List<String> listFilesFromDir(String dirPath) {
        List<String> listFiles;

        file = new File(dirPath);

        if (file.isDirectory()) {
            listFiles = Arrays.asList(file.list());
            return listFiles;
        }
        return null;
    }

    /**
     * Get List of strings in files text
     *
     * @param file any file
     * @return ArrayList of strings content or empty array list if it directory
     */
    public static List<String> readFiles(File file) {
        List<String> fileBody = new ArrayList<>();

        if (file.isFile()) {
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                String out;
                while ((out = bufferedReader.readLine()) != null) {
                    fileBody.add(out);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please create him");
            } catch (IOException ioe) {
                System.out.println("Some happened with readers");
            } finally {
                try {
                    fileReader.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("C't close readers, sorry");
                }
            }
        }
        return fileBody;
    }

    /**
     * Write in the file
     *
     * @param content list of any information
     */
    public static void writeToFile(File file, List<String> content) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter;

        if (file.isFile()) {
            try {
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);

                for (String nextString : content) {
                    bufferedWriter.write(nextString);
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
            } catch (IOException e) {
                System.out.println("That happen?? I c't read.");
            } finally {
                try {
                    fileWriter.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("D't close writers");
                }
            }
        }
    }

    /**
     * Write byte array into file
     *
     * @param file    any file
     * @param content array of the bytes
     */
    public static void writeToFile(File file, byte[] content) {
        if (file.isDirectory()) {
            System.out.println(file.getName() + " is directory");
        } else {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(content);
                } catch (IOException e) {
                    System.out.println("Incorrect output, sorry");
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
