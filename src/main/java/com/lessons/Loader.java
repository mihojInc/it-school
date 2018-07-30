package com.lessons;

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

    public String getUrlLine() {
        return urlLine;
    }

    public void setUrlLine(String urlLine) throws EmptyURLException {
        if (urlLine == null || urlLine.length() == 0) {
            throw new EmptyURLException();
        }
        this.urlLine = urlLine;
    }

    public void load() throws IOException {
        URL url = new URL(urlLine);
        int begin = urlLine.lastIndexOf("/");
        if (begin == -1) {
            System.out.println("index of urlLine = -1");
            return;
        }
        String name = urlLine.substring(begin + 1, urlLine.length());
        Path path2 = Paths.get("C:\\Users\\Alina\\IdeaProjects\\it-school\\it-school_16\\src\\main\\java\\com\\lessons\\Images");
        if (!Files.exists(path2)) {
            Files.createDirectories(path2);
        }
        Path downloadPath = Paths.get("C:\\Users\\Alina\\IdeaProjects\\it-school\\it-school_16\\src\\main\\java\\com\\lessons\\Images\\" + name);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(downloadPath.toFile());
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }

}
