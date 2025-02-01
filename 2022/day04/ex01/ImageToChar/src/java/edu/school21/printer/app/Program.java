// Copyright 2025 stranger

package edu.school21.printer.app;

import java.nio.file.Path;

import edu.school21.printer.logic.BMPConverter;

public class Program{
    private static Path argsValidation(final String[] args){
        System.out.println(args.length);

        if(args.length != 1){
            System.err.println("There are no arguments here or more than 1");
            System.exit(-1);
        }

        final Path path = Path.of(args[0]);

        if(!path.isAbsolute()){
            System.err.println("It is not absolute path to file");
            System.exit(-1);
        }

        return path;
    }

    public static void main(String[] args){
        final Path path = argsValidation(args);

        BMPConverter.toCharArray(path);
    }
}