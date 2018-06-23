package src.com.lessons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static File getFile(String path) {

        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Файл не найден!");
            return null;
        } else {


            System.out.println("Файл найден!");
            return file;
        }

    }


    public static List<File> getFiles(String directoryPath) {
        File dir = new File(directoryPath);
        // если объект представляет каталог
        List<File> fileInDir = new ArrayList<File>();
        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (File item : dir.listFiles()) {
                fileInDir.add(item);
            }
        } else {
            System.out.println("По этому пути каталога нет");
        }
        return fileInDir;
    }


    public static List<String> listFilesFromDir(String directoryPath) {
        File dir = new File(directoryPath);
        // если объект представляет каталог
        List<String> listFile = new ArrayList<String>();
        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (String item : dir.list()) {

                listFile.add(item);
            }

        } else {

            System.out.println("По этому пути нет файлов");

        }
        return listFile;

    }


    public static List<String> readFile(File file) {
        FileReader fr = null;
        BufferedReader br = null;
        List<String> listFile = new ArrayList<>();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String item;
            while ((item = br.readLine()) != null) {
                listFile.add(item);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");

        } catch (IOException e) {
            System.out.println("Ошибка запист файла!");
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("Поток FileReader закрылся с ошибкой");
            }
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Поток BufferedReader закрылся с ошибкой");
            }
        }

        return listFile;

    }

    public static void writeToFile(File file, List<String> text) {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);


            //bw = new BufferedWriter(fw);
            for (String strF : text) {

                try {
                    bw.write(strF);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {


            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void writeToFile(File file, byte[] info) {

    }
}
