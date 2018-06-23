package src.com.lessons;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Работа с файлами:");
        File myfile = new File("C:\\Users\\master\\IdeaProjects\\it-school9workclass\\src\\com\\lessons\\myfile.log");
        System.out.println(myfile.exists());


        // в статических методах не нужно создавать объекты класса
        String path = "C:\\Users\\master\\IdeaProjects\\it-school9workclass\\src\\com\\lessons\\myfile.log";
        String pathL = "C:\\Users\\master\\IdeaProjects\\it-school9workclass\\src\\com\\lessons\\logs.txt";
        String directoryPath = "C:\\Users\\master\\IdeaProjects\\it-school9workclass\\src\\com\\lessons\\";


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

    }

}
