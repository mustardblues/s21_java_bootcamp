// Copyright 2025 stranger

import java.util.Scanner;

public class exercise06{
    public static void main(String[] args){
        double[] array = userInput();

        sortSelection(array);

        showElements(array);
    }

    static double[] userInput(){
        double[] array;

        Scanner in = new Scanner(System.in);

        while(true){
            if(!in.hasNextInt()){
                in.nextLine();

                System.out.println("Couldn't parse a number. Please, try again.");

                continue;
            }

            int size = in.nextInt();

            if(size <= 0){
                System.out.println("Input error. Size <= 0.");

                System.exit(1);
            }

            array = new double[size];

            break;
        }

        in.nextLine();

        int i = 0;

        while(i < array.length){
            if(!in.hasNextDouble()){
                in.nextLine();

                System.out.println("Couldn't parse a number. Please, try again.");

                i = 0;

                continue;
            }

            array[i++] = in.nextDouble();
        }

        return array;
    }

    static void sortSelection(double[] array){
        for(int i = 0; i < array.length - 1; ++i){
            int min_index = i;

            for(int j = i + 1; j < array.length; ++j){
                if(array[min_index] > array[i]) min_index = j;
            }

            if(min_index != i){
                double temp = array[min_index];
                array[min_index] = array[i];
                array[i] = temp;
            }
        }
    }

    static void showElements(final double[] array){
        for(double element : array){
            System.out.print(element + " ");
        }

        System.out.println();
    }
}