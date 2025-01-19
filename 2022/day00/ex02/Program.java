// Copyright 2025 stranger

package day00.ex02;

import java.util.*;

public class Program{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int request = 0;
        int coffeeCount = 0;

        while(true){
            if(in.hasNextInt()){
                request = in.nextInt();

                if(request == 42) break;

                if(primeNumber(sumOfDigits(request))){
                    System.out.println(request);
                    ++coffeeCount;
                }
            }
        }

        System.out.println("Count of coffee-request – "
                + coffeeCount);
    }

    static int sumOfDigits(int value){
        int result = 0;

        while(value > 0){
            result += value % 10;
            value /= 10;
        }

        return result;
    }

    static boolean primeNumber(final int value){
        if(value <= 0) return false;

        final int length = (int)Math.round(Math.sqrt(value));

        for(int i = 2; i <= length; ++i){
            if((value % i) == 0) return false;
        }

        return true;
    }
}