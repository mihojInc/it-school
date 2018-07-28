package com.lessons;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Can download file from internet
 */
public class Downloader {

    private final static String LOG = "../it-school/src/main/resources/images/log.txt";

    /**
     * Get all url from file
     */
    public List<String> getAllUrl(Path path) {
        List<Path> paths = new ArrayList<>();
        try {
            return Files.readAllLines(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void loadAllFiles(int how) {
        List<Callable<String>> downloadTask = new ArrayList<>();
        List<String> listPaths = getAllUrl(Paths.get("../it-school/src/main/resources/paths.txt"));

        if (how > listPaths.size()) {
            how = listPaths.size();
        }

        listPaths = listPaths.subList(0, how);

        for (String path : listPaths) {
            Callable<String> task = () -> {
                String name = load(path);
                return Thread.currentThread().getName() + " success download " + name;
            };
            downloadTask.add(task);
        }

        ExecutorService executorService = Executors.newWorkStealingPool();
        try {
            List<Future<String>> stringList = executorService.invokeAll(downloadTask);
                    stringList.stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Load file by his String path in internet
     * Returned name of downloaded file
     */
    public String load(String source) {

        String[] strings = source.split("/");
        String filename = strings[strings.length - 1];

        Path pathToCopy = Paths.get("../it-school/src/main/resources/images/" + filename);
        logSave(Thread.currentThread().getName() + " download " + filename);

        InputStream inputStream = null;

        try {
            URL url = new URL(source);
            inputStream = url.openStream();

            Files.copy(inputStream, pathToCopy, StandardCopyOption.REPLACE_EXISTING);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return filename;
    }

    /**
     * Write download logs in log.txt
     * @param text bit of log
     */
    private void logSave(String text) {
        try {
            text += "\n";
            Files.write(Paths.get(LOG), text.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void downloadFromConsole(String url) {
        if (url.equals("")) {
            System.out.println("ups"); //todo validation url
        } else {
        String name = load(url);
            System.out.println(name + " success download");
        }
    }

    static {
        try {
            if (!Files.exists(Paths.get("../it-school/src/main/resources/images"))) {
                Files.createDirectory(Paths.get("../it-school/src/main/resources/images"));
            }
            Files.write(Paths.get(LOG), "".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
