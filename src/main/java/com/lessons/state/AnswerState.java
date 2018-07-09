package com.lessons.state;

import org.apache.commons.io.input.CountingInputStream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.SortedMap;
import java.util.TreeMap;

public class AnswerState {
    private Long currentLine = 1L;
    private Long totalLines = 1L;
    private SortedMap<Long, Long> lineByteStart = new TreeMap<>();

    public AnswerState(File file) {
        try (CountingInputStream cis = new CountingInputStream(Files.newInputStream(Paths.get(file.toURI())))) {
            lineByteStart.put(currentLine, cis.getByteCount());
            int c;
            while ((c = cis.read()) != -1) {
                if (c == '\n') {
                    totalLines++;
                    lineByteStart.put(totalLines, cis.getByteCount());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentLine(Long currentLine) {
        this.currentLine = currentLine;
    }

    public Long getCurrentLine() {
        return currentLine;
    }

    public Long getTotalLines() {
        return totalLines;
    }

    public SortedMap<Long, Long> getLineByteStart() {
        return lineByteStart;
    }
}
