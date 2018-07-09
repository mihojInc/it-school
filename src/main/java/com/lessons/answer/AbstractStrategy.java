package com.lessons.answer;

import com.lessons.state.AnswerState;
import com.lessons.state.AnswerStateHolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class AbstractStrategy implements AnswerStrategy {

    @Override
    public String getMessage(File file) {
        AnswerState answerState = AnswerStateHolder.getState(file);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            setCurrentPosition(answerState, randomAccessFile);
            return new String(randomAccessFile.readLine().getBytes("iso-8859-1"), "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected abstract void setCurrentPosition(AnswerState state, RandomAccessFile randomAccessFile) throws IOException;
}
