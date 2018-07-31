package com.lessons;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LogService {
    private volatile File file;
    private String logFile;

    public LogService(File file) {
        this.file = file;
    }

    public synchronized void addLog(String text) throws IOException {
        FileManager.appendFile(file, text);
    }
}
