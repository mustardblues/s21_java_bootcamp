// Copyright 2025 stranger

package day03.ex03;

import java.util.*;
import java.util.concurrent.*;

public class FileDownloadManager{
     private static class ManagerThreadFactory implements ThreadFactory{
         private static int id = 0;

         @Override
         public Thread newThread(Runnable var1){
             return new Thread(var1, "Thread-" + ++id);
         }
     }

    public static void download(Queue<String> links, final int threadsCount){
        ExecutorService executor =
                Executors.newFixedThreadPool(threadsCount, new ManagerThreadFactory());

        while(!links.isEmpty()){
            final String link = links.poll();

            if(link != null){
                executor.execute(new FileDownload(link));
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