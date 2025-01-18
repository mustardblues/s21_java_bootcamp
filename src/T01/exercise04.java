// Copyright 2025 stranger

package T01;

import java.util.Scanner;

public class exercise04{
    public static void main(String[] args){
        try {
            calculateNegAverage(userInput());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }

    static int[] userInput() throws Exception{
        Scanner in = new Scanner(System.in);

        final int length = inputInt(in);

        if(length <= 0){
            throw new Exception("Input error. Size <= 0.");
        }

        return inputIntArray(in, length);
    }

    static int inputInt(Scanner in){
        for(; true; ){
            if(!in.hasNextInt()){
                System.out.println("Couldn't parse a number. Please, try again.");
                in.nextLine();

                continue;
            }

            final int value = in.nextInt();
            in.nextLine();

            return value;
        }
    }

    static int[] inputIntArray(Scanner in, final int length){
        int[] array = new int[length];

        for(int i = 0; i < length;){
            if(!in.hasNextInt()){
                System.out.println("Couldn't parse a number. Please, try again.");
                in.nextLine();

                continue;
            }

            array[i++] = in.nextInt();
        }

        return array;
    }

    static void calculateNegAverage(final int[] array){
        int sum = 0, count = 0;

        for(int value : array){
            if(value < 0){
                sum += value;

                ++count;
            }
        }

        if(count > 0){
            System.out.println(sum / count);
        }
        else{
            System.out.println("There are no negative elements.");
        }
    }
}