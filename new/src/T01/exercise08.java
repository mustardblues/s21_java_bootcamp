// Copyright 2025 stranger

package T01;

import java.util.Scanner;

public class exercise08{
    public static void main(String[] args){
        inputAscendingOrder();
    }

    static void inputAscendingOrder(){
        Scanner in = new Scanner(System.in);

        if(!in.hasNextInt()){
            System.out.println("Input error.");
            return;
        }

        int previous = in.nextInt();

        while(true){
            if(!in.hasNextInt()){
                System.out.println("The sequence is ordered in ascending order.");

                break;
            }

            final int current = in.nextInt();

            if(previous > current){
                System.out.println("The sequence is not ordered " +
                        "from the ordinal number of the number " + current + ".");

                break;
            }

            previous = current;
        }
    }
}