// Copyright 2025 stranger

package day02.ex02;

import java.nio.file.Path;

public class Program{
    public static void main(String[] args){
        if(args.length != 0 && args[0].contains("--current-folder=")){
            FileManager manager = new FileManager(args[0].substring(17));

            manager.start();
        }
    }
}