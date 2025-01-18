// Copyright 2025 stranger

package T01;

import java.util.Scanner;

public class exercise06{
    public static void main(String[] args){
        try{
            double[] array = userInput();

            sortSelection(array);

            for(double value : array){
                System.out.print(value + " ");
            }

            System.out.println();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }

    static double[] userInput() throws Exception{
        Scanner in = new Scanner(System.in);

        final int length = inputInt(in);

        if(length <= 0){
            throw new Exception("Input error. Size <= 0.");
        }

        return inputDoubleArray(in, length);
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

    static double[] inputDoubleArray(Scanner in, final int length){
        double[] array = new double[length];

        int index = 0;

        while(index < length){
            if(!in.hasNextDouble()){
                System.out.println("Couldn't parse a number. Please, try again.");
                in.nextLine();

                continue;
            }

            array[index++] = in.nextDouble();
        }

        return array;
    }

    static void sortSelection(double[] array){
        for(int i = 0; i < array.length; ++i){
            int min_index = i;

            for(int j = i + 1; j < array.length; ++j){
                if(array[min_index] > array[j]) min_index = j;
            }

            if(min_index != i){
                double temp = array[min_index];
                array[min_index] = array[i];
                array[i] = temp;
            }
        }
    }
}