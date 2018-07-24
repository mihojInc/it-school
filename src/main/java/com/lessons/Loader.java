package com.lessons;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Loader extends Throwable {
    String link = "";

    public void setLink(String link) throws EmptyURLException{
        if (link == null || link.length() == 0) {
            throw new EmptyURLException();
        }
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void load() throws IOException {
        URL url = new URL(link);
        int begin = link.lastIndexOf("/");
        if (begin == -1) {
            System.out.println("you enter incorrect link");
            return;
        }
        String name = link.substring(begin + 1, link.length());
        Path path2 = Paths.get("./src/main/java/com/lessons/images");
        if (!Files.exists(path2)) {
            Files.createDirectories(path2);
        }
        Path downloadPath = Paths.get("./src/main/java/com/lessons/images/" + name);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(downloadPath.toFile());
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }
}
