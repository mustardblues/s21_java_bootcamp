// Copyright 2025 stranger

package edu.school21.printer.app;

import java.nio.file.Path;

import com.beust.jcommander.JCommander;

import edu.school21.printer.logic.Args;
import edu.school21.printer.logic.BMPConverter;

public class Program{
    public static void main(String[] args){
        try{
            Args parameters = new Args();

            JCommander.newBuilder()
                .addObject(parameters)
                .build()
                .parse(args);

            BMPConverter.toCharArray(Path.of("/resources/baks.bmp"), parameters);
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}