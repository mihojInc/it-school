package src.main.java.com.lessons;

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
        loader.setUrlLine(url);
        loader.load();
        System.out.println(i);
        return "Loading image complete" + i;
    }
}
