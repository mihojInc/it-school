package com.lessons;

import java.util.concurrent.Callable;

/**
 * Этот класс загружает одну картинку, которая передана в конструкторе
 */
public class CallableImageLoader implements Callable<String> {
    private String url;//ссылка на загружаемую картинку
    private int i; // хрень непонятная
    private LogService log;

    public CallableImageLoader(int i, String url, LogService log) {
        this.url = url;
        this.i = i;
        this.log = log;
    }

    @Override
    public String call() throws Exception {
        Loader loader = new Loader();
        loader.setUrlLine(url);
        loader.load(url, log);
        System.out.println(i);
        return "Loading image complete" + i;
    }
}
