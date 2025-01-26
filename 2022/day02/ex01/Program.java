// Copyright 2025 stranger

package day02.ex01;

public class Program{
    public static void main(String[] args){
        if(args.length == 0){
            System.exit(-1);
        }

        int size = Words.createDictionary(args[0], args[1]);

        int[] vector1 = new int[size];
        int[] vector2 = new int[size];

        Words.wordFrequency(vector1, vector2, args[0], args[1]);

        System.out.format("Similarity = %.2f\n",  Words.similarity(vector1, vector2));
    }
}