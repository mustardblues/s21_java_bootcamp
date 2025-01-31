// Copyright 2025 stranger

package day03.ex00;

public class Program{
    static class localRun implements Runnable{
        private final int count;

        localRun(final int count){
            this.count = count;
        }

        @Override
        public void run(){
            for(int i = 0; i < count; ++i){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args){
        if(args.length != 1){
            System.exit(-1);
        }

        if(!args[0].startsWith("--count=")){
            System.exit(-1);
        }

        int count = 0;

        try{
            count = Integer.parseInt(args[0].split("=")[1]);
        }
        catch(NumberFormatException ex){
            System.exit(-1);
        }

        Thread egg = new Thread(new localRun(count), "Egg");
        Thread hen = new Thread(new localRun(count), "Hen");

        Thread.currentThread().setName("Human");

        egg.start();
        hen.start();

        try {
            egg.join();
            hen.join();

            for(int i = 0; i < 5; ++i){
                System.out.println(Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}