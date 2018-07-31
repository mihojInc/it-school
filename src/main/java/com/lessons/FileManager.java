package com.lessons;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {
    /**
     * Процедура принимает на вход ссылку на файл и возвращает список строк в виде List
     *
     * @param path
     */
    public static List<String> getListFiles(String path, int count) {
        File[] files = new File(path).listFiles();

        List<File> fileList = Arrays.asList(files);
        List<String> strings = fileList.stream()
                .limit(count)
                .map(a -> a.getPath())
                .collect(Collectors.toList());
        return strings;
    }

    /**
     * Возвращает список строк в переданном файле
     *
     * @param path  файл откуда надо прочитать строки
     * @param count количество строк в файле которы необходимо прочитать
     * @return
     * @throws IOException
     */
    public static List<String> readFile(String path, int count) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

        return lines.stream().limit(count).collect(Collectors.toList());
    }


    /**
     * Процедура выводит на печать список файлов в указанной дирректории
     */
    public static void printListOfFile(String path) {

        Arrays.stream(new File(path).listFiles()).forEach(System.out::println);
    }

    /**
     * Процедура дополняет файл, списком строк
     */
    public static void appendFile(File file, String list) throws IOException {

        FileWriter fr = null;

        fr = new FileWriter(file, true);
        fr.write(list);
        fr.flush();
        fr.close();
    }
}
