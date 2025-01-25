// Copyright 2025 stranger

package day02.ex00;

import java.io.*;
import java.util.*;

public class FileSignature{
    public static Map<String, String> mapSignatures(final String filename){
        final File file = new File(filename);

        try(Scanner fin = new Scanner(file)){
            final Map<String, String> hexMap = new HashMap<>();

            while(fin.hasNextLine()){
                final String line = fin.nextLine();

                final String[] array = line.split(",");

                if(array.length == 2){
                    hexMap.put(array[1].trim(), array[0].trim());
                }
            }

            return hexMap;

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());

            return null;
        }
    }

    public static String fileSignature(final String filename) {
        try(FileInputStream fis = new FileInputStream(filename)){
            byte[] byteSignature = new byte[8];

            if(fis.read(byteSignature) == -1){
                throw new Exception("No more data because " +
                        "the end of the file has been reached");
            }

            final StringBuilder builder = new StringBuilder();

            for(byte value : byteSignature){
                builder.append(String.format("%02X ", value));
            }

            return builder.toString().trim();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());

            return null;
        }
    }

    public static void writeFileFormat(final Map<String, String> hexMap,
                                       final String hexCode){
        try(FileOutputStream fos = new FileOutputStream("result.txt", true)){

            for(Map.Entry<String, String> element : hexMap.entrySet()){
                final String key = element.getKey();

                if(hexCode.contains(key)){
                    fos.write((hexMap.get(key) + "\n").getBytes());

                    break;
                }
            }

            System.out.println("PROCESSED");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}