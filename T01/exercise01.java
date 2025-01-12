// Copyright 2025 stranger

import java.util.Scanner;

public class exercise01 {
    static double[] userInput(final int length){
        double[] coordinates = new double[length];

        Scanner in = new Scanner(System.in);

        for(int i = 0; i < length; ++i){
            if(!in.hasNextDouble()){
                System.out.println("Couldn't parse a number. Please, try again.");

                in.next();

                i = -1;

                continue;
            }

            coordinates[i] = in.nextDouble();
        }

        return coordinates;
    }

    static void showTrianglePerimeter(final double[] coordinates){
        if(!isTriangle(coordinates)){
            System.out.println("It isn't triangle.");

            return;
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

    public static void main(String[] args){
        showTrianglePerimeter(userInput(6));
    }
}