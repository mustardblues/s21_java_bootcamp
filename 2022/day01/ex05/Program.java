// Copyright 2025 stranger

package day01.ex05;

public class Program{
    public static void main(String[] args){
        String mode = args.length > 0 ? args[0] : "";

        Menu menu = new Menu(mode);

        menu.start();
    }
}