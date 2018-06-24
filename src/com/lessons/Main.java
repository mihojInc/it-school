package src.com.lessons;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Работа с файлами:");
        File myfile = new File("C:\\Users\\master\\IdeaProjects\\it-school9workclass\\src\\com\\lessons\\myfile.log");
        System.out.println(myfile.exists());


        String path = "C:\\Users\\master\\IdeaProjects\\it-school9workclass\\src\\com\\lessons\\myfile.log";
        String pathL = "C:\\Users\\master\\IdeaProjects\\it-school9workclass\\src\\com\\lessons\\logs.txt";
        String pathF = "C:\\Users\\master\\IdeaProjects\\it-school9workclass\\src\\com\\lessons\\fonts.txt";
        String directoryPath = "C:\\Users\\master\\IdeaProjects\\it-school9workclass\\src\\com\\lessons\\";

        // в статических методах не нужно создавать объекты класса
        for (String sps : FileUtil.listFilesFromDir(directoryPath)) {

            System.out.println(sps);
        }
        System.out.println("------------------");
        System.out.println("Вывод содержимого файла: ");

        for (String spsF : FileUtil.readFile(myfile)) {

            System.out.println(spsF);
        }
        File logFile = new File(pathL);
        FileUtil.writeToFile(logFile, FileUtil.listFilesFromDir(directoryPath));

        File fontFile = new File(pathF);
        FileUtil.writeToFile(fontFile, new String("font size 12p").getBytes());

    }

}
