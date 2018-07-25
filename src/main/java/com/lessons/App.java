package src.main.java.com.lessons;

import src.main.java.com.lessons.EmptyURLException;
import src.main.java.com.lessons.Loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws EmptyURLException, IOException, InterruptedException{
        Loader loader = new Loader();
        String[] arrayLink = new String[] {
                "https://o-viber.ru/wp-content/uploads/2017/08/smeh-18.png",
                "https://sfw.so/uploads/posts/2011-03/1300730574_ddd-1.jpg",
                "http://minionomaniya.ru/wp-content/uploads/2015/08/%D0%9C%D0%B8%D0%BD%D1%8C%D0%BE%D0%BD-%D0%91%D0%BE%D0%B1.jpg",
                "http://w-hatsapp.ru/wp-content/uploads/2017/05/screenshot-2017-05-19-001-6.png",
                "http://w-hatsapp.ru/wp-content/uploads/2017/05/7-4.png",
                "http://img.gazeta.ru/files3/717/3990717/bmw-pic452-452x452-36449.jpg",

        };
        ExecutorService service = Executors.newFixedThreadPool(arrayLink.length);
        List<CallableImageLoader> listThreads = new ArrayList<CallableImageLoader>();
        for (int i = 0; i<arrayLink.length; i++ ){
            listThreads.add( new CallableImageLoader(i+1, arrayLink[i]));
        }
        CompletionService<String> completionService = new ExecutorCompletionService(service);
        for (CallableImageLoader elem: listThreads) {
            if (elem instanceof Callable) {
                completionService.submit(elem);
            }
        }
        for (int i = 0; i < arrayLink.length; i++) {
            try {
                String result = completionService.take().get().toString();
                System.out.println("result is " + result);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();

  /*      for (String link: arrayLink) {
            loader.setUrlLine(link);
            loader.load();
        } */

    }


}
