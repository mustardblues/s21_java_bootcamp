// Copyright 2025 stranger

package day03.ex03;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public record FileDownload(String link) implements Runnable{
    @Override
    public void run(){
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
    }
}