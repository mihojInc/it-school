package com.lessons;

public class App {
    public static void main(String[] args) throws NoSuchMethodException {
        ILogger iLogger = ProxyFactory.getInstance(new Logger());
        ILogger iLogger2 = ProxyFactory.getInstance(new Logger2());

        iLogger.toLog("asdasd");
        iLogger.toJournal("asdasd11111");
    }
}
