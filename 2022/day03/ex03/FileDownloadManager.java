// Copyright 2025 stranger

package day03.ex03;

import java.util.*;
import java.util.concurrent.*;

public class FileDownloadManager{
     private static class ManagerThreadFactory implements ThreadFactory{
         @Override
         public Thread newThread(Runnable var1){
             return new Thread(var1);
         }
     }

    public static void download(Queue<String> links, final int threadCount){
        ExecutorService executor =
                Executors.newFixedThreadPool(threadCount, new ManagerThreadFactory());

        while(!links.isEmpty()){
            final String link = links.poll();

            if(link != null){
                executor.submit(new FileDownload(link));
            }
        }

        executor.shutdown();

        try{
            if(!executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MICROSECONDS)){
                executor.shutdownNow();
            }
        }
        catch(InterruptedException ex){
            executor.shutdownNow();
        }
    }
}