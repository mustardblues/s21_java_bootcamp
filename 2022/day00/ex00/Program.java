// Copyright 2025 stranger

package day00.ex00;

public class Program{
    public static void main(String[] args){
        int number = Math.abs(479598);

        int sum = 0;

        while(number > 0){
            sum += number % 10;
            number /= 10;
        }

        System.out.println(sum);
    }
}