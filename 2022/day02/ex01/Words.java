// Copyright 2025 stranger

package day02.ex01;

import java.io.*;
import java.util.*;

public class Words{
    public static int createDictionary(final String filename1, final String filename2){
        Set<String> wordsSet = new TreeSet<>();

        try(BufferedReader reader1 = new BufferedReader(new FileReader(filename1));
            BufferedReader reader2 = new BufferedReader(new FileReader(filename2))){

            String line;

            while((line = reader1.readLine()) != null){
                final String[] array = line.replaceAll("\\p{Punct}", "").split(" ");

                Collections.addAll(wordsSet, array);
            }

            while((line = reader2.readLine()) != null){
                final String[] array = line.replaceAll("\\p{Punct}", "").split(" ");

                Collections.addAll(wordsSet, array);
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());

            return -1;
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.txt"))){
            final String[] array = wordsSet.toArray(new String[0]);

            for(int i = 0; i < array.length - 1; ++i){
                writer.write(array[i] + ", ");
            }

            writer.write(array[array.length - 1]);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());

            return -1;
        }

        return wordsSet.size();
    }

    public static void wordFrequency(final int[] vector1,
                                     final int[] vector2,
                                     final String filename1,
                                     final String filename2){
        try(BufferedReader dictionary = new BufferedReader(new FileReader("dictionary.txt"));
            BufferedReader reader1 = new BufferedReader(new FileReader(filename1));
            BufferedReader reader2 = new BufferedReader(new FileReader(filename2))){

            final List<String> wordsList = new ArrayList<>();

            Collections.addAll(wordsList, dictionary.readLine().split(", "));

            String line;

            while((line = reader1.readLine()) != null){
                final String[] array = line.replaceAll("\\p{Punct}", "").split(" ");

                for(String value : array){
                    final int index = wordsList.indexOf(value);
                    ++vector1[index];
                }
            }

            while((line = reader2.readLine()) != null){
                final String[] array = line.replaceAll("\\p{Punct}", "").split(" ");

                for(String value : array){
                    final int index = wordsList.indexOf(value);
                    ++vector2[index];
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static double similarity(final int[] vector1, final int[] vector2){
        double numerator = 0;

        for(int i = 0; i < vector1.length; ++i){
            numerator += vector1[i] * vector2[i];
        }

        double sqrtA = 0;
        double sqrtB = 0;

        for(int i = 0; i < vector1.length; ++i){
            sqrtA += vector1[i] * vector1[i];
            sqrtB += vector2[i] * vector2[i];
        }

        final double denominator = Math.abs(Math.sqrt(sqrtA) * Math.abs(Math.sqrt(sqrtB)));

        return denominator > 0 ? Math.floor(numerator / denominator * 100) / 100 : 0;
    }
}