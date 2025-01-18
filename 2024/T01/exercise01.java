// Copyright 2025 stranger

package T01;

import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args){
        try{
            trianglePerimeter(userInput());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }

    static double[] userInput(){
        double[] coordinates = new double[6];

        Scanner in = new Scanner(System.in);

        for(int i = 0; i < coordinates.length; ){
            if(!in.hasNextDouble()){
                System.out.println("Couldn't parse a number. Please, try again.");
                in.nextLine();

                continue;
            }

            coordinates[i++] = in.nextDouble();
        }

        return coordinates;
    }

    static void trianglePerimeter(final double[] coordinates) throws Exception{
        if(!isTriangle(coordinates)){
            throw new Exception("It isn't triangle.");
        }

        final double side_1 =
                Math.sqrt(Math.pow(coordinates[3] - coordinates[1], 2)
                        + Math.pow(coordinates[2] - coordinates[0], 2));

        final double side_2 =
                Math.sqrt(Math.pow(coordinates[5] - coordinates[1], 2)
                        + Math.pow(coordinates[4] - coordinates[0], 2));

        final double side_3 =
                Math.sqrt(Math.pow(coordinates[5] - coordinates[3], 2)
                        + Math.pow(coordinates[4] - coordinates[2], 2));

        final double perimeter = side_1 + side_2 + side_3;

        System.out.printf("Perimeter: %.3f\n", perimeter);
    }

    static boolean isTriangle(final double[] coordinates){
        if(coordinates.length != 6) return false;

        final double y1 = coordinates[0] - coordinates[2];
        final double y2 = coordinates[0] - coordinates[4];
        final double y3 = coordinates[2] - coordinates[4];

        final double x1 = coordinates[1] - coordinates[3];
        final double x2 = coordinates[1] - coordinates[5];
        final double x3 = coordinates[3] - coordinates[5];

        return !((y1 * x2 == y2 * x1) ||
                ((y1 == 0 && x1 == 0) || (y2 == 0 && x2 == 0) || (y3 == 0 && x3 == 0)));
    }
}