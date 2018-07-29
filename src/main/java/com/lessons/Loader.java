package src.main.java.com.lessons;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Loader {

    private static String logFile = "C:\\Users\\master\\IdeaProjects\\it-school_task16_image\\src\\main\\java\\com\\lessons\\sourse\\Log";

    public List<String> getUrl(Path path) {
        List<Path> paths = new ArrayList<>();
        try {
            return Files.readAllLines(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //download images from file
    public void fromFile() {
        List<Callable<String>> listTask = new ArrayList<>();
        List<String> listPaths = getUrl(Paths.get("C:\\Users\\master\\IdeaProjects\\it-school_task16_image\\src\\main\\java\\com\\lessons\\sourse\\Links"));

        listPaths = listPaths.subList(0, listPaths.size());

        for (String path : listPaths) {
            Callable<String> oper = () -> {
                String name = load(path);
                return Thread.currentThread().getName() + " loading is complete " + name;
            };
            listTask.add(oper);
        }

        ExecutorService executorService = Executors.newWorkStealingPool();
        try {
            List<Future<String>> stringList = executorService.invokeAll(listTask);
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
  //logging of all operations
    public void logging(String text) {
        try {
            text += "\n";
            Files.write(Paths.get(logFile), text.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //creating files
    public String load(String source) {

        String[] strings = source.split("/");
        String filename = strings[strings.length - 1];

        Path pathToCopy = Paths.get("images\\" + filename);
        logging(Thread.currentThread().getName() + " download " + filename);

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

    //download images from the console
    public void fromConsole(String url) {
        if (url.equals("")) {
            System.out.println("you entered an incorrect link");
        } else {
            String name = load(url);
            System.out.println(name + " loading is complete");
        }
    }

    static {
        try {
            if (!Files.exists(Paths.get("images\\"))) {
                Files.createDirectory(Paths.get("images\\"));
            }
            Files.write(Paths.get(logFile), "".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
