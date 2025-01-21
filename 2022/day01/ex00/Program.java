// Copyright 2025 stranger

package day01.ex00;

public class Program{
    public static void main(String[] args){
        int[] array = function();

        for(int value : array){
            System.out.print(value + " ");
        }
    }

    static int[] function(){
        int[] array = new int[7];

        return array;
    }
}