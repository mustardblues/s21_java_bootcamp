// Copyright 2025 stranger

package T02;

import java.util.*;

public class exercise02{
    static abstract class Animal{
        private int age;
        private double mass;
        private String name;

        Animal(final int age, final double mass, final String name){
            this.age = age;
            this.mass = mass;
            this.name = name;
        }

        public int getAge(){
            return age;
        }

        public double getMass(){
            return mass;
        }

        String getName(){
            return name;
        }

        public boolean setAge(final int age){
            if(age <= 0){
                System.out.println("Incorrect input. Age <= 0");

                return false;
            }

            this.age = age;

            return true;
        }

        public boolean setMass(final double mass){
            if(mass <= 0){
                System.out.println("Incorrect input. Mass <= 0");

                return false;
            }

            this.mass = mass;

            return true;
        }

        public boolean setName(final String name){
            if(name == null){
                System.out.println("Incorrect input. Name = null");

                return false;
            }

            this.name = name;

            return true;
        }

        abstract public double getFeedInfoKg();
    }

    static class Dog extends Animal{
        Dog(final int age, final double mass, final String name){
            super(age, mass, name);
        }

        @Override
        public double getFeedInfoKg(){
            return this.getMass() * 0.3;
        }

        @Override
        public String toString(){
            return "Dog name = " + this.getName()
                    + ", age = " + this.getAge()
                    + ", mass = " + this.getMass()
                    + ", feed = " + this.getFeedInfoKg();
        }
    }

    static class Cat extends Animal{
        Cat(final int age, final double mass, final String name){
            super(age, mass, name);
        }

        @Override
        public double getFeedInfoKg(){
            return this.getMass() * 0.1;
        }

        @Override
        public String toString(){
            return "Cat name = " + this.getName()
                    + ", age = " + this.getAge()
                    + ", mass = " + this.getMass()
                    + ", feed = " + this.getFeedInfoKg();
        }
    }

    public static void main(String[] args){

    }

    static List<Animal> inputAnimalList(){
        Scanner in = new Scanner(System.in);

        final int capacity = inputInt(in);

        List<Animal> pets = new ArrayList<>(capacity);

        for(int i = 0; i < capacity; ++i){
            final String type = in.next();
            in.nextLine();

            Animal animal = null;

            if(type.equalsIgnoreCase("dog")){
                animal = new Dog(0, 0, null);
            }
            else if(type.equalsIgnoreCase("cat")){
                animal = new Cat(0, 0, null);
            }
            else{
                System.out.println("");

                continue;
            }
        }

        return pets;
    }

    static int inputInt(Scanner in){
        while(true){
            if(!in.hasNextInt()){
                System.out.println("Couldn't parse a number. Please, try again");

                in.nextLine();

                continue;
            }

            final int number = in.nextInt();

            in.nextLine();

            return number;
        }
    }

    static double inputDouble(Scanner in){
        while(true){
            if(!in.hasNextDouble()){
                System.out.println("Couldn't parse a number. Please, try again");

                in.nextLine();

                continue;
            }

            final double number = in.nextDouble();

            in.nextLine();

            return number;
        }
    }
}