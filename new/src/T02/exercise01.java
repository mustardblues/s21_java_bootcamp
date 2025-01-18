// Copyright 2025 stranger

package T02;

import java.util.*;

public class exercise01{
    static abstract class Animal{
        private int age;
        private String name;

        Animal(final int age, final String name){
            this.age = age;
            this.name = name;
        }

        int getAge(){
            return age;
        }

        String getName(){
            return name;
        }

        void setAge(final int age){
            this.age = age;
        }

        void setName(final String name){
            this.name = name;
        }
    }

    static class Dog extends Animal{
        Dog(final int age, final String name){
            super(age, name);
        }

        @Override
        public String toString(){
            return "Dog name = " + getName() + ", age = " + getAge();
        }
    }

    static class Cat extends Animal{
        Cat(final int age, final String name){
            super(age, name);
        }

        @Override
        public String toString(){
            return "Cat name = " + getName() + ", age = " + getAge();
        }
    }

    public static void main(String[] args){
        List<Animal> pets = inputAnimalList();

        for(Animal element : pets){
            System.out.println(element.toString());
        }
    }

    static List<Animal> inputAnimalList(){
        Scanner in = new Scanner(System.in);

        final int animal_count = inputInt(in);

        List<Animal> pets = new ArrayList<>();

        for(int i = 0; i < animal_count; ++i){
            Animal animal;

            final String type = in.next();
            in.nextLine();

            if(type.equalsIgnoreCase("dog")){
                animal = new Dog(0, null);
            }
            else if(type.equalsIgnoreCase("cat")){
                animal = new Cat(0, null);
            }
            else{
                System.out.println("Incorrect input. Unsupported pet type");

                continue;
            }

            final String name = in.next();
            in.nextLine();

            final int age = inputInt(in);

            if(age > 0){
                animal.setAge(age);
                animal.setName(name);

                pets.add(animal);
            }
            else{
                System.out.println("Incorrect input. Age <= 0");
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
}