// Copyright 2025 stranger

package T01;

import java.util.Scanner;

public class exercise03{
    public static void main(String[] args){
        showFibonacciNumber(userInput());
    }

    static long userInput(){
        Scanner in = new Scanner(System.in);

        while(true){
            if(!in.hasNextLong()){
                in.nextLine();

                System.out.println("Couldn't parse a number. Please, try again.");

                continue;
            }

            return in.nextLong();
        }
    }

    static void showFibonacciNumber(final long number){
        if(number > 40){
            System.out.println("Too large " + number + ".");
            System.exit(1);
        }
        else if(number < 0){
            System.out.println("Too small " + number + ".");
            System.exit(1);
        }

        System.out.println(calculateFibonacci(number));
    }

    static long calculateFibonacci(final long number){
        if(number <= 1) return number;

        return calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
    }
}