// Copyright 2025 stranger

package T01;

import java.util.Scanner;

public class exercise03{
    public static void main(String[] args){
        try{
            final int value = userInput();

            if(value > 40) throw new Exception("Too large " + value + ".");

            System.out.println(fibonacci(value));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }

    static int userInput(){
        Scanner in = new Scanner(System.in);

        while(true){
            if(!in.hasNextInt()){
                System.out.println("Couldn't parse a number. Please, try again.");
                in.nextLine();

                continue;
            }

            return in.nextInt();
        }
    }

    static int fibonacci(final int value){
        if(value <= 1) return value;

        return fibonacci(value - 1) + fibonacci(value - 2);
    }
}