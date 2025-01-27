// Copyright 2025 stranger

package day02.ex02;

import java.io.*;
import java.nio.file.*;

import java.util.*;
import java.util.stream.*;

public class FileManager{
    private interface Method{
        void method();
    }

    private String[] userInput;

    private Path currentFolderPath;

    private final List<String> consoleCommands = List.of("ls", "cd", "mv");

    final Method[] methods = {
            this::folderContent,
            this::setCurrentFolderPath,
            this::moveCommand
    };

    public FileManager(final String path){
        Path folderPath = Path.of(path);

        if(!folderPath.isAbsolute()){
            System.exit(-1);
        }

        if(!Files.isDirectory(folderPath)){
            System.exit(-1);
        }

        currentFolderPath = folderPath;
    }

    public void start(){
        final Scanner in = new Scanner(System.in);

        while(true){
            System.out.print("-> ");
            userInput = in.nextLine().split(" ");

            if("exit".equals(userInput[0])){
                break;
            }

            final int index = consoleCommands.indexOf(userInput[0]);

            if(index >= 0 && index < methods.length){
                methods[index].method();
            }
        }
    }

    public void folderContent(){
        final File folder = new File(currentFolderPath.toString());

        if(!folder.isDirectory()){
            return;
        }

        try{
            for(File item : Objects.requireNonNull(folder.listFiles())){

                if(item.isDirectory()){
                    System.out.println(item.getName() + " " + calculateFolderSize(item) / 1024 + " KB");
                }
                else{
                    System.out.println(item.getName() + " " + item.length() / 1024 + " KB");
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static long calculateFolderSize(final File folder) throws IOException{
        try(Stream<Path> stream = Files.walk(folder.toPath())){
            return stream
                    .filter(p-> p.toFile().isFile())
                    .mapToLong(p-> p.toFile().length())
                    .sum();
        }
    }

    public void setCurrentFolderPath(){
        if(userInput.length != 2){
            return;
        }

        Path folderPath = currentFolderPath.resolve(userInput[1]).normalize();

        if(Files.isDirectory(folderPath)){
            currentFolderPath = folderPath;

            System.out.println(currentFolderPath);
        }
    }

    public void moveCommand(){
        if(userInput.length != 3){
            return;
        }

        final Path content1 = Path.of(userInput[1]);
        final Path content2 = Path.of(userInput[2]);

        try{
            if(Files.isDirectory(content2)){
                Files.move(content1,
                        content2.resolve(content1.getFileName()),
                        StandardCopyOption.REPLACE_EXISTING);
            }
            else if(!Files.isDirectory(Path.of(userInput[1]))){
                Files.move(content1, content2.resolveSibling(Paths.get(userInput[1])));
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}