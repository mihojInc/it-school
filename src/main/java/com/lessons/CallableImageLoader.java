package com.lessons;

import java.util.concurrent.Callable;

public class CallableImageLoader implements Callable<String> {
    private String url;
    private int i;

    public CallableImageLoader(int i, String url) {
        this.url = url;
        this.i = i;
    }

    @Override
    public String call() throws Exception {
        Loader loader = new Loader();
        int begin = url.lastIndexOf("/");
        String name = url.substring(begin + 1, url.length());
        loader.setLink(url);
        loader.load();
        System.out.println("Loading image complete " + name);
        return "Loading image complete " + name;
    }
}