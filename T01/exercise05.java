// Copyright 2025 stranger

import java.util.Scanner;

class exercise05{
    static int[] inputIntArray(){
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
            else{
                array = new int[size];

                break;
            }
        }

        in.nextLine();

        for(int i = 0; i < array.length; ++i){
            if(!in.hasNextInt()){
                in.nextLine();

                System.out.println("Couldn't parse a number. Please, try again.");

                i = -1;

                continue;
            }

            array[i] = in.nextInt();
        }

        return array;
    }

    static void showNumbersWithSameFirstAndLast(final int[] array){
        int[] numbers = new int[array.length];

        int count = 0;

        for(int num : array){
            int last_digit = num % 10;
            int first_digit = num;

            while(first_digit > 9) first_digit /= 10;

            if(first_digit == last_digit){
                numbers[count++] = num;
            }
        }

        if(count > 0){
            for(int i = 0; i < count; ++i){
                System.out.print(numbers[i] + " ");
            }
        }
        else{
            System.out.print("There are no such elements.");
        }

        System.out.println();
    }

    public static void main(String[] args){
        showNumbersWithSameFirstAndLast(inputIntArray());
    }
}