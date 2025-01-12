// Copyright 2025 stranger

import java.util.Scanner;

public class exercise05{
    static int[] userInput(){
        int[] array;

        Scanner in = new Scanner(System.in);

        while(true){
            if(!in.hasNextInt()){
                in.nextLine();
                
                System.out.println("Couldn't parse a number. Please, try again.");

                continue;
            }

            final int size = in.nextInt();

            if(size <= 0){
                System.out.println("Input error. Size <= 0.");
                System.exit(1);
            }

            array = new int[size];

            break;
        }

        in.nextLine();

        int i = 0;

        while(i < array.length){
            if(!in.hasNextInt()){
                in.nextLine();

                System.out.println("Couldn't parse a number. Please, try again.");

                i = 0;

                continue;
            }

            array[i++] = in.nextInt();
        }

        return array;
    }

    static int[] findSingleDigits(final int[] array){
        int i = 0, j = 0;

        while(i < array.length){
            int last = array[i] % 10;
            int first = array[i];

            while(first > 9) first /= 10;

            if(first == last) j++;

            ++i;
        }

        int[] result = new int[j];

        i = j = 0;

        while(i < array.length){
            int last = array[i] % 10;
            int first = array[i];

            while(first > 9) first /= 10;

            if(first == last) result[j++] = array[i];

            ++i;
        }

        return result;
    }

    static void showElements(final int[] array){
        if(array.length == 0){
            System.out.println("There are no such elements.");

            return;
        }

        int i = 0;

        while(i < array.length){
            System.out.print(array[i++] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args){
       showElements(findSingleDigits(userInput()));
    }
}