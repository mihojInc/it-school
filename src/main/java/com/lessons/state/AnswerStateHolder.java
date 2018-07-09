package com.lessons.state;

import java.io.File;
import java.util.SortedMap;
import java.util.TreeMap;

public class AnswerStateHolder {

    private static SortedMap<File, AnswerState> stateMap = new TreeMap<>();
    private static File currentFile;

    public static AnswerState getState(File file) {
        return stateMap.get(file);
    }

    public static AnswerState getState() {
        return stateMap.get(currentFile);
    }

    public static File getCurrentFile() {
        return currentFile;
    }

    public static void setCurrentFile(File currentFile) {
        AnswerStateHolder.currentFile = currentFile;
    }

    public static void putFileToState(File file) {
        currentFile = file;
        stateMap.put(file, new AnswerState(file));
    }
}
