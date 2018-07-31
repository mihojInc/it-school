package com.lessons;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class  LogService{
    public static void run(DownloadService downloadService, File file){
        FileUtil fileUtil = new FileUtil();
        for(String log: downloadService.getLogList()){
            fileUtil.appedToFile(file, log);
        }
    }
}
