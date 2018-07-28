package com.lessons;

public class Logger implements ILogger {

    @Override
    @Count(count = 2)
    public void toLog(String value) {
        System.out.println(value);
    }

    @Override
    @Count(count = 10)
    public void toJournal(String value) {
        System.out.println(value);
    }
}
