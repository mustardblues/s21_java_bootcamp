// Copyright 2025 stranger

import java.util.Scanner;

public class exercise02{

    static long inputLong(){
        Scanner in = new Scanner(System.in);

        while(true){
            if(!in.hasNextLong()){
                in.nextLine();

                System.out.println("Couldn't parse a number. Please, try again");

                continue;
            }

            return in.nextLong();
        }
    }

    static long[] calculateTime(final long seconds){
        if(seconds < 0){
            System.out.println("Incorrect time.");

            System.exit(1);
        }

        long[] time = new long[3];

        time[0] = seconds / 3600;
        time[1] = (seconds - time[0] * 3600) / 60;
        time[2] = seconds - time[0] * 3600 - time[1] * 60;

        return time;
    }

    static void showTime(final long[] time){
        String format = String.format("%02d:%02d:%02d", time[0], time[1], time[2]);

        System.out.println(format);
    }

    public static void main(String[] args){
        showTime(calculateTime(inputLong()));

    }
}