package com.lessons.answer;

import com.lessons.state.AnswerState;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomStrategy extends AbstractStrategy {

    @Override
    protected void setCurrentPosition(AnswerState state, RandomAccessFile randomAccessFile) throws IOException {
        long generatedLong = new RandomDataGenerator().nextLong(1l, state.getTotalLines());
        state.setCurrentLine(generatedLong);
        randomAccessFile.seek(state.getLineByteStart().get(generatedLong));
    }
}
