// Copyright 2025 stranger

import java.util.Scanner;

public class exercise08{
    public static void main(String[] args){
        detectAscendingOrder(userInput());
    }

    static String userInput(){
        Scanner in = new Scanner(System.in);

        StringBuilder line = new StringBuilder();

        while(in.hasNextInt()) line.append(in.next()).append(" ");

        return line.toString();
    }

    static void detectAscendingOrder(final String line){
        if(line.isEmpty()){
            System.out.println("Input error.");

            return;
        }

        Scanner reader = new Scanner(line);

        int current = 0, previous = reader.nextInt();
        boolean is_ascending_order = true;

        while(reader.hasNextInt()){
            current = reader.nextInt();

            if(current < previous){
                is_ascending_order = false;

                break;
            }

            previous = current;
        }

        if(is_ascending_order){
            System.out.println("The sequence is ordered in ascending order.");
        }
        else{
            System.out.println("The sequence is not ordered " +
                    "from the ordinal number of the number " + current + ".");
        }
    }
}