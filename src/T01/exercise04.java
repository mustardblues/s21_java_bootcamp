// Copyright 2025 stranger

package T01;

import java.util.Scanner;

public class exercise04{
    public static void main(String[] args){
        showNegativeAverage(userInput());
    }

    static int[] userInput(){
        int[] array;

        Scanner in = new Scanner(System.in);

        for(; true;){
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

        if(count_neg_numbers != 0){
            System.out.println(sum_neg_numbers / count_neg_numbers);
        }
    }
}