// Copyright 2025 stranger

package edu.school21.printer.logic;

// Для работы с библиотекой JCommander
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Args{
    @Parameter(names = "--white", required = true)
    private String white;

    @Parameter(names = "--black", required = true)
    private String black;

    public String white(){
        return white;
    }

    public String black(){
        return black;
    }
}