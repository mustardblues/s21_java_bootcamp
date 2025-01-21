// Copyright 2025 stranger

package day00.ex05;

import java.util.*;
import java.util.stream.Stream;

public class Program{
    static final String[] weekDays = new String[]{
            "MO", "TU", "WE", "TH", "FR", "SA", "SU"
    };

    static final String[] monthDays = new String[]{
            "TU", "WE", "TH", "FR", "SA", "SU", "MO",
            "TU", "WE", "TH", "FR", "SA", "SU", "MO",
            "TU", "WE", "TH", "FR", "SA", "SU", "MO",
            "TU", "WE", "TH", "FR", "SA", "SU", "MO",
            "TU", "WE"
    };

    static final int[] dayNumber = new int[]{
            1, 2, 3, 4, 5, 6, 0,
            1, 2, 3, 4, 5, 6, 0,
            1, 2, 3, 4, 5, 6, 0,
            1, 2, 3, 4, 5, 6, 0,
            1, 2
    };

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        final String[] students = getStudents(in);

        final int[] timetable = getTimetable(in);

        final int studentNumber = (int)Stream.of(students)
                .filter(Objects::nonNull).count();

        final int[][][] attendance =
                getAttendance(in, students, studentNumber);

        printTable(attendance, students, timetable, studentNumber);
    }

    static String[] getStudents(Scanner in){
        String[] students = new String[10];

        for(int i = 0, length = students.length; i < length; ++i){
            final String line = in.next();
            in.nextLine();

            if(line.equals(".")){
                break;
            }

            students[i] = line;
        }

        return students;
    }

    static int[] getTimetable(Scanner in){
        int[] timetable = new int[]{0, 0, 0, 0, 0, 0, 0};

        while(true){
            final String line = in.nextLine();

            if(line.equals(".")){
                break;
            }

            final String[] splitLine = line.split(" ");

            if(splitLine.length == 2){
                int time = toTime(splitLine[0]);
                int day = toWeekDay(splitLine[1]);

                if((day >= 0 && day < 7) && (time > 0 && time < 6)){
                    timetable[day] = time;
                }
            }
        }

        return timetable;
    }

    static int[][][] getAttendance(Scanner in, final String[] students, final int studentNumber){
        int[][][] attendance = new int[studentNumber][30][5];

        while(true){
            final String line = in.nextLine();

            if(line.equals(".")){
                break;
            }

            final String[] splitLine = line.split(" ");

            if(splitLine.length == 4){
                final int student = studentIndex(students, splitLine[0], studentNumber);
                final int time = toTime(splitLine[1]);
                final int day = toMonthDay(splitLine[2]);

                if((student != -1) && (day != -1)){
                    if(splitLine[3].equals("HERE")){
                        attendance[student][day][time] = 1;
                    }
                    else if(splitLine[3].equals("NOT_HERE")){
                        attendance[student][day][time] = -1;
                    }
                }
            }
        }

        return attendance;
    }

    static void printTable(final int[][][] attendance, final String[] students,
                           final int[] timetable, final int studentNumber){
        final int maxIndent = Stream.of(students)
                .filter(Objects::nonNull)
                .mapToInt(String::length)
                .max().orElse(0);

        System.out.printf("%" + maxIndent + "s", "");

        for(int i = 0; i < 30; ++i){
            final int time = timetable[dayNumber[i]];

            if(time != 0){
                if(i < 10){
                    System.out.printf("%d:00 %s  %d|", time, monthDays[i], i + 1);
                }
                else{
                    System.out.printf("%d:00 %s %d|", time, monthDays[i], i + 1);
                }
            }
        }

        for(int i = 0; i < studentNumber; ++i){
            System.out.print("\n" + students[i]);

            for(int j = 0; j < 30; ++j){
                final int time = timetable[dayNumber[j]];

                if(time != 0){
                    if(attendance[i][j][time] == 1){
                        System.out.printf("%9s1|", "");
                    }
                    else if(attendance[i][j][time] == -1){
                        System.out.printf("%8s-1|", "");
                    }
                    else{
                        System.out.printf("%10s|", "");
                    }
                }
            }
        }
    }

    static int toTime(final String line){
        final char[] digits = line.toCharArray();

        int time = digits[0];

        for(int i = 1; i < digits.length; ++i){
            time *= 10 + digits[i] - 48;
        }

        return time - 48;
    }

    static int toWeekDay(final String line){
        for(int i = 0; i < weekDays.length; ++i){
            if(line.equals(weekDays[i])){
                return i;
            }
        }

        return -1;
    }

    static int studentIndex(final String[] students,
                            final String line, final int studentNumber){
        for(int i = 0; i < studentNumber; ++i){
            if(line.equals(students[i])){
                return i;
            }
        }

        return -1;
    }

    static int toMonthDay(final String line){
        final char[] digits = line.toCharArray();

        int day = digits[0] - 48;

        for(int i = 1; i < digits.length; ++i){
            day = day * 10 + (digits[i] - 48);
        }

        return (day > 0) && (day < 31) ? day - 1 : -1;
    }
}