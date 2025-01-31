// Copyright 2025 stranger

package day03.ex03;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public record FileDownload(String link) implements Runnable{
    private static int downloadCount = 0;

    @Override
    public void run(){
        final int fileNumber = ++downloadCount;

        System.out.println(Thread.currentThread().getName() +
                " start download file number " +
                fileNumber);

        URL url;

        try{
            url = new URL(link);
        }
        catch(MalformedURLException ex){
            System.err.println(ex.getMessage());
            return;
        }

        try (BufferedInputStream in = new BufferedInputStream(url.openStream())){
            Files.copy(in, Path.of(url.getFile()).getFileName(), REPLACE_EXISTING);
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }

        System.out.println(Thread.currentThread().getName() +
                " finish download file number " +
                fileNumber);
    }
}