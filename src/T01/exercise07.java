// Copyright 2025 stranger

package T01;

import java.io.*;
import java.util.Scanner;

public class exercise07{
    static class Pair{
        public double first;
        public double second;

        Pair(final double first, final double second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        try{
           double[] array = getArrayFromFile(userInput());

            showArrayDouble(array);

            writeMaxAndMinElements(findMaxAndMinElements(array));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());

            System.exit(1);
        }
    }

    static String userInput(){
        Scanner in = new Scanner(System.in);

        return in.next();
    }

    static double[] getArrayFromFile(final String filename) throws Exception{
        File file = new File(filename);

        if(!file.exists()) throw new Exception("Input error. File isn't exist.");

        Scanner reader  = new Scanner(file);

        int array_length = 0;

        while(reader.hasNext()){
            if(reader.hasNextInt()){
                array_length = reader.nextInt();
                break;
            }

            reader.next();
        }

        if(array_length <= 0) throw new Exception("Input error. Size <= 0.");

        double[] array = new double[array_length];

        int counter = 0;

        while(reader.hasNext()){
            if(reader.hasNextDouble()){
                array[counter++] = reader.nextDouble();
                continue;
            }

            reader.next();
        }

        if(counter != array_length) throw new Exception("Input error. Insufficient number of elements.");

        return array;
    }

    static void showArrayDouble(final double[] array){
        if(array == null) return;

        System.out.println(array.length);

        for(double element : array){
            System.out.print(element + " ");
        }

        System.out.println();
    }

    static Pair findMaxAndMinElements(final double[] array){
        double max = 0, min = array[0];

        for(int i = 1; i < array.length; ++i){
            if(max < array[i]){
                max = array[i];
            }
            else if(min > array[i]){
                min = array[i];
            }
        }

        return new Pair(min, max);
    }

    static void writeMaxAndMinElements(final Pair pair) throws Exception{
        if(pair == null) return;

        System.out.println("Saving min and max values in file.");

        try(PrintWriter writer = new PrintWriter("result.txt")) {
            writer.print(pair.first + " " + pair.second);
        }
        catch(IOException ex){
            throw new Exception("File writing error.");
        }
    }
}