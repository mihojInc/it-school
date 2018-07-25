package src.main.java.com.lessons;

import src.main.java.com.lessons.EmptyURLException;

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

    // getter for URL
    public String getUrlLine() {
        return urlLine;
    }

    //setter for URL
    public void setUrlLine(String urlLine) throws EmptyURLException {
        if (urlLine == null || urlLine.length() == 0) {
            throw new EmptyURLException("Link of image is null");
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
        //put name of file
        String name = urlLine.substring(begin + 1, urlLine.length());
        Path path2 = Paths.get("images");
        if (!Files.exists(path2)) {
            Files.createDirectories(path2);
        }
        Path downloadPath = Paths.get("images\\" + name);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(downloadPath.toFile());
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }

}
