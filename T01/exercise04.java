// Copyright 2025 stranger

import java.util.Scanner;

public class exercise04{
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

    static void showNegativeAverage(final int[] array){
        int sum_neg_numbers = 0, count_neg_numbers = 0;

        for(int i = 0; i < array.length; ++i){
            if(array[i] < 0){
                sum_neg_numbers += array[i];

                ++count_neg_numbers;
            }
        }

        System.out.println(sum_neg_numbers / count_neg_numbers);
    }

    public static void main(String[] args){
        showNegativeAverage(inputIntArray());
    }
}