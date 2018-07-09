package com.lessons;

import com.lessons.answer.RandomStrategy;
import com.lessons.processor.AbstractProcessor;
import com.lessons.processor.ChangeStrategyProcessor;
import com.lessons.processor.MathProcessor;
import com.lessons.state.AnswerStateHolder;

import java.io.File;
import java.util.Scanner;

public class App {

    ChatBotMessagePrinter printer = new ChatBotMessagePrinter();
    AbstractProcessor processor;

    App() {
        printer.setAnswerStrategy(new RandomStrategy());
        processor = new MathProcessor(new ChangeStrategyProcessor(null));
        AnswerStateHolder.putFileToState(new File("/Users/macbookpro/IdeaProjects/it-school/src/main/resources/answers"));
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(AnswerStateHolder.getState().getTotalLines());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {
                String next = scanner.nextLine();
                if (next.equals("-q")) {
                    return;
                }
                if (!app.getProcessor().proccess(next, app)) {
                    app.getPrinter().printMessage();
                }
            }
        }
    }

    public AbstractProcessor getProcessor() {
        return processor;
    }

    public ChatBotMessagePrinter getPrinter() {
        return printer;
    }
}
