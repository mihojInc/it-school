package com.lessons.LogService;

import com.lessons.DownloadService.Loader;

import java.util.concurrent.Callable;

public class CallableImagesLoader implements Callable<String> {

    //URL адресс
    private String url;
    //Порядковый номер загружаемых url адресов
    private int index;

    //Constructor
    public CallableImagesLoader(int index, String url) {
        this.url = url;
        this.index = index;
    }

    @Override
    public String call() throws Exception {
        Loader loader = new Loader();
        loader.setUrlLine(url);
        loader.loadImage();
        System.out.println(index);
        return "Loading image complete: " + index;
    }
}
