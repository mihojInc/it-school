package com.lessons;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    private FileWriter writer;

    public WriteFile(FileWriter writer) {
        this.writer = writer;
    }

    public void writeFile(String text)
    {

        try
        {

            writer.append(text);
            // запись по символам
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}
