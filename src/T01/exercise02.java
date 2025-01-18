// Copyright 2025 stranger

package T01;

import java.util.Scanner;

public class exercise02{
    public static void main(String[] args){
        try{
            long[] clock = calculateTime(userInput());

            String format = String.format("%02d:%02d:%02d", clock[0], clock[1], clock[2]);
            System.out.println(format);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }

    static long userInput(){
        Scanner in = new Scanner(System.in);

        while(true){
            if(!in.hasNextLong()){
                System.out.println("Couldn't parse a number. Please, try again.");
                in.nextLine();

                continue;
            }

            return in.nextLong();
        }
    }

    static long[] calculateTime(final long seconds) throws Exception{
        if(seconds < 0){
            throw new Exception("Incorrect time.");
        }

        long[] time = new long[3];

        time[0] = seconds / 3600;
        time[1] = (seconds - time[0] * 3600) / 60;
        time[2] = seconds - time[0] * 3600 - time[1] * 60;

        return time;
    }
}