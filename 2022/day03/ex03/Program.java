// Copyright 2025 stranger

package day03.ex03;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Program{
    private static int validationOfThreadsCount(final String[] args){
        if(args.length != 1){
            System.err.println("No command-line arguments or more than 1");
            System.exit(-1);
        }

        if(!args[0].startsWith("--threadsCount=")){
            System.err.println("There are no valid parameters");
            System.exit(-1);
        }

        int threadsCount = 0;

        try{
            threadsCount = Integer.parseInt(args[0].substring(15));
        }
        catch(NumberFormatException ex){
            System.err.println(ex.getMessage());
            System.exit(-1);
        }

        if((threadsCount < 1) || (threadsCount > 10)){
            System.err.println("threadCount is too small or too large");
            System.exit(-1);
        }

        return threadsCount;
    }

    public static void main(String[] args){
        final int threadsCount = validationOfThreadsCount(args);

        try(BufferedReader in = new BufferedReader(
                new FileReader("2022/day03/ex03/files_urls.txt"))){

            Deque<String> links = new ConcurrentLinkedDeque<>();

            String temp;

            while((temp = in.readLine()) != null){
                links.offer(temp);
            }

            FileDownloadManager.download(links, threadsCount);
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }
}