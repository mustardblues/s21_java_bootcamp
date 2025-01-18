// Copyright 2025 stranger

package T01;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class exercise07{
    static class Pair{
        public double first;
        public double second;
    }

    public static void main(String[] args) {
        try{
            double[] array = readArrayFromFile(inputFileName());

            writeMaxAndMinValues(getMaxAndMinValues(array));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }

    static String inputFileName(){
        Scanner in = new Scanner(System.in);

        return in.next();
    }

    static double[] readArrayFromFile(final String filename) throws Exception{
        File file = new File(filename);

        if(!file.exists()){
            throw new Exception("Input error. File isn't exist.");
        }

        Scanner reader = new Scanner(file);

        int length = 0;

        while(reader.hasNext()){
            if(reader.hasNextInt()){
                length = reader.nextInt();
                break;
            }

            reader.next();
        }

        if(length <= 0){
            throw new Exception("Input error. Size <= 0.");
        }

        int index = 0;

        double[] array = new double[length];

        while(index < array.length){
            if(!reader.hasNext()) break;

            if(!reader.hasNextDouble()) reader.next();

            array[index++] = reader.nextDouble();
        }

        if(index != array.length){
            throw new Exception("Input error. Insufficient number of elements.");
        }

        return array;
    }

    static Pair getMaxAndMinValues(final double[] array){
        Pair pair = new Pair();

        pair.first = Arrays.stream(array).min().getAsDouble();
        pair.second = Arrays.stream(array).max().getAsDouble();

        return pair;
    }

    static void writeMaxAndMinValues(final Pair pair) throws Exception{
        System.out.println("Saving min and max values in file.");

        try(PrintWriter writer = new PrintWriter("result.txt")) {
            writer.print(pair.first + " " + pair.second);
        }
        catch(IOException ex){
            throw new Exception("File writing error.");
        }
    }
}