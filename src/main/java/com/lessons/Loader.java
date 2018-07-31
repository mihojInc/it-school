package com.lessons;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс призводит загрузку картинки, которая передана параметром в функциою load
 */
public class Loader {
    private String urlLine = "";

    public String getUrlLine() {
        return urlLine;
    }

    /**
     * @param urlLine
     * @throws EmptyURLException
     */
    public void setUrlLine(String urlLine) throws EmptyURLException {
        if (urlLine == null || urlLine.length() == 0) {
            throw new EmptyURLException("Link of image is null");
        }
        this.urlLine = urlLine;
    }

    /**
     * Процедцра копирует переданную ссылку в папку
     *
     * @param urlLine
     * @param log
     * @throws IOException
     * @throws EmptyURLException
     */
    public synchronized void load(String urlLine, LogService log) throws IOException, EmptyURLException {

        if (urlLine == null || urlLine.length() == 0) {
            throw new EmptyURLException("Link of image is null");
        }
        this.urlLine = urlLine;
        //создаем ссылку по строке
        URL url = new URL(urlLine);
        //получаем индекс символа начала имени файла а не пути
        int begin = urlLine.lastIndexOf("/");
        //вероятно получили хрень
        if (begin == -1) {
            System.out.println("index of urlLine = -1");
            return;
        }
        //Получаем им файла
        String name = urlLine.substring(begin + 1, urlLine.length());

        //получаем путь
        Path path2 = Paths.get("images");
        //если такого пути нет - создаем
        if (!Files.exists(path2)) {
            Files.createDirectories(path2);
        }
        //Получаем путь к картинке
        Path downloadPath = Paths.get("images\\" + name);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(downloadPath.toFile());

        //Копируем
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        System.out.println("Картинка " + urlLine + " скопирована");
        log.addLog("Картинка " + urlLine + " скопирована\n");
    }
}