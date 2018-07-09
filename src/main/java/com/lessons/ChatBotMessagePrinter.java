package com.lessons;

import com.lessons.answer.AnswerStrategy;
import com.lessons.state.AnswerStateHolder;

public class ChatBotMessagePrinter {

    private AnswerStrategy answerStrategy;

    public void printMessage() {
        System.out.println(answerStrategy.getMessage(AnswerStateHolder.getCurrentFile()));
    }

    public AnswerStrategy getAnswerStrategy() {
        return answerStrategy;
    }

    public void setAnswerStrategy(AnswerStrategy answerStrategy) {
        this.answerStrategy = answerStrategy;
    }
}
