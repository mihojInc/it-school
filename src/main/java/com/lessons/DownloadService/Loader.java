package com.lessons.DownloadService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Loader {
    private String urlLine = "";

    //Getters and Setters
    public String getUrlLine() {
        return urlLine;
    }

    //Сдесь мы генерируем исключение в том слечае если url == null
    //Или длинна адреса url == 0
    public void setUrlLine(String urlLine) throws EmptyURLException{
        if(urlLine == null || urlLine.length() == 0) {
            throw new EmptyURLException();
        }
        this.urlLine = urlLine;
    }

    public void loadImage() throws IOException {
        //Строку преобразуем в URL класс
        URL url = new URL(urlLine);
        int begin = urlLine.lastIndexOf("/");
        if(begin == -1) {
            System.out.println("Your URL address is incorrect!");
            return;
        }
        //Из ссылки вырезаем имя файла и сохраняем в переменную name
        String name = urlLine.substring(begin + 1, urlLine.length());
        //Создаем путь к папке где будем хранить скачаные картинки
        //Если такой папки нет, создаем её
        Path path = Paths.get("/home/denis/Programming/it-school/src/main/java/com/lessons/images");
        if(!Files.exists(path)){
            Files.createDirectories(path);
        }

        //Тут мы создаем путь, по которому будем хранить картинку
        Path downloadPath = Paths.get("/home/denis/Programming/it-school/src/main/java/com/lessons/images/" + name);
        //Потом создаем канал ReadableByteChannel в который кладем поток байтов извлеченный из path
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        //Формируем поток символов для записи в файл
        FileOutputStream fileOutputStream = new FileOutputStream(downloadPath.toFile());
        //Записываем в файл с помощью потока символов fileOutputStream байты из канала readableByteChannel
        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    }
}
