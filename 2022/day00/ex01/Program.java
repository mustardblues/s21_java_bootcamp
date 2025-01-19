// Copyright 2025 stranger

package day00.ex01;

import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        if(!in.hasNextInt()) return;

        int number = in.nextInt();

        if(number <= 0){
            System.out.println("Illegal Argument");
            System.exit(-1);
        }

        int iteration = 0;
        boolean isPrimeNumber = true;
        final int length = (int)Math.round(Math.sqrt(number));

        for(int i = 2; i <= length; ++i){
            ++iteration;

            if((number % i) == 0){
                isPrimeNumber = false;

                break;
            }
        }

        System.out.println(isPrimeNumber + " " + iteration);
    }
}