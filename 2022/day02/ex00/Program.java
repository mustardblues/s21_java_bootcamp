// Copyright 2025 stranger

package day02.ex00;

import java.util.*;

public class Program{
    public static void main(String[] args){
        final Scanner in = new Scanner(System.in);

        final Map<String, String> hexMap = FileSignatures.mapSignatures(
                "2022/day02/ex00/signatures.txt");

        while(true){
            System.out.print("-> ");
            final String filename = in.nextLine();

            if(filename.equals("42")){
                break;
            }

            final String hexCode = FileSignatures.fileSignature(filename);

            FileSignatures.writeFileFormat(hexMap, hexCode);
        }
    }
}