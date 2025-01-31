// Copyright 2025 stranger

package day03.ex02;

import java.util.Arrays;
import java.util.Random;

public class Program{
    public static int sumByThreads = 0;

    static class ArraySummation implements Runnable{
        private final int id;

        private final int start;
        private final int end;

        private final int[] array;

        public ArraySummation(final int id,
                              final int[] array,
                              final int start,
                              final int end){
            this.id = id;

            this.start = start;
            this.end = end;

            this.array = array;
        }

        @Override
        public void run(){
            int sum = 0;

            for(int i = start; i <= end; ++i){
                sum += array[i];
            }

            sumByThreads += sum;

            System.out.println("Thread " +
                    id + ": from " +
                    start + " to " +
                    end + " sum is " +
                    sum);
        }
    }

    static class Validation{
        public int arraySize = 0;
        public int threadsCount = 0;

        public Validation(final String[] args){
            if(args.length != 2){
                System.exit(-1);
            }

            if((!args[0].startsWith("--arraySize=")) ||
                    (!args[1].startsWith("--threadsCount="))){
                System.exit(-1);
            }

            try{
                this.arraySize = Integer.parseInt(args[0].split("=")[1]);
                this.threadsCount = Integer.parseInt(args[1].split("=")[1]);
            }
            catch(NumberFormatException ex){
                System.out.println(ex.getMessage());
                System.exit(-1);
            }

            if((this.arraySize > 2000000) || (this.threadsCount > this.arraySize)){
                System.exit(-1);
            }
        }
    }

    public static void main(String[] args){
        Validation v = new Validation(args);

        final int[] array = new int[v.arraySize];

        final Random rand = new Random();

        for(int i = 0; i < array.length; ++i){
            array[i] = rand.nextInt(1000);
        }

        System.out.println("Sum: " + Arrays.stream(array).sum());

        final Thread[] threads = new Thread[v.threadsCount];

        final int section = array.length / threads.length;

        int start = 0;
        int end = section;

        for(int i = 0; i < threads.length; ++i){
            threads[i] = new Thread(
                    new ArraySummation(i + 1, array, start, end));

            threads[i].start();

            start = end + 1;
            end += section + 1;

            if(end >= array.length){
                end = array.length - 1;
            }
        }

        try{
            for(Thread th : threads){
                th.join();
            }
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Sum by threads: " + sumByThreads);
    }
}