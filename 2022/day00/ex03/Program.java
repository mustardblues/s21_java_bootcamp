// Copyright 2025 stranger

package day00.ex03;

import java.util.*;

public class Program{
    public static void main(String[] args){
        List<Integer> grades = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        for(int i = 1; i <= 18; ++i){
            final String week = in.nextLine();

            if(week.equals("42")){
                break;
            }
            else if(!week.equals("Week " + i)){
                System.out.println("Incorrect input");
                System.exit(-1);
            }

            final int minGrade = findMinGrade(in.nextLine());

            if(minGrade > 0){
                System.out.println("Incorrect input");
                System.exit(-1);
            }

            grades.add(minGrade);
        }

        printStatistic(grades);
    }

    static int findMinGrade(final String grades){
        Scanner in = new Scanner(grades);

        int minGrade = Integer.MAX_VALUE;
        int count = 0;

        while(in.hasNextInt()){
            final int grade = in.nextInt();

            if((grade > 0 && grade < 9) && (minGrade > grade)){
                minGrade = grade;
            }

            ++count;
        }

        in.close();

        return count == 5 ? minGrade : 0;
    }

    static void printStatistic(final List<Integer> grades){
        for(int i = 1, size = grades.size(); i <= size; ++i){
            System.out.print("Week " + i + " ");

            for(int j = 0, length = grades.get(i - 1); j < length; ++j){
                System.out.print("=");
            }

            System.out.println(">");
        }
    }
}