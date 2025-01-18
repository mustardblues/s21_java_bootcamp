// Copyright 2025 stranger

package T01;

import java.util.*;

public class exercise05{
    public static void main(String[] args){
        try{
            final int[] array = userInput();

            int count = 0;

            for(int value : array){
                if(isIdenticalFirstAndLastDigits(value)){
                    ++count;
                }
            }

            int[] identical_digits = new int[count];

            count = 0;

            for(int value : array){
                if(isIdenticalFirstAndLastDigits(value)){
                    identical_digits[count++] = value;
                }
            }

            for(int value : identical_digits){
                System.out.print(value + " ");
            }

            System.out.println();
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
        while(true){
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

        int index = 0;

        while(index < length){
            if(!in.hasNextInt()){
                System.out.println("Couldn't parse a number. Please, try again.");
                in.nextLine();

                continue;
            }

            array[index++] = in.nextInt();
        }

        return array;
    }

    static boolean isIdenticalFirstAndLastDigits(final int value){
        int last = value % 10;

        int first = value;

        while(first > 9) first /= 10;

        return first == last;
    }
}