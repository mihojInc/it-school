package com.lessons.answer;

import com.lessons.state.AnswerState;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UpseqStrategy extends AbstractStrategy {

    @Override
    protected void setCurrentPosition(AnswerState state, RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.seek(state.getLineByteStart().get(state.getCurrentLine()));
        if (state.getCurrentLine().equals(state.getTotalLines())) {
            state.setCurrentLine(1L);
        } else {
            state.setCurrentLine(state.getCurrentLine() + 1);
        }
    }
}
