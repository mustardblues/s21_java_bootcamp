// Copyright 2025 stranger

package day03.ex01;

public class Program{
    static class Printer{
        private boolean switchMode = false;

        public Printer(){}

        public synchronized void printEgg(final int count){
            for(int i = 0; i < count; ++i){
                while(switchMode){
                    try{
                        wait();
                    }
                    catch(InterruptedException ex){
                        System.out.println(ex.getMessage());
                    }
                }

                System.out.println("Egg");

                switchMode = true;

                notify();
            }
        }

        public synchronized void printHen(final int count){
            for(int i = 0; i < count; ++i){
                while(!switchMode){
                    try{
                        wait();
                    }
                    catch(InterruptedException ex){
                        System.out.println(ex.getMessage());
                    }
                }

                System.out.println("Hen");

                switchMode = false;

                notify();
            }
        }
    }

    static class EggThread implements Runnable{
        private final int count;
        private final Printer printer;

        public EggThread(final int count, final Printer printer){
            this.count = count;
            this.printer = printer;
        }

        @Override
        public void run(){
            printer.printEgg(count);
        }
    }

    static class HenThread implements Runnable{
        private final int count;
        private final Printer printer;

        public HenThread(final int count, final Printer printer){
            this.count = count;
            this.printer = printer;
        }

        @Override
        public void run(){
            printer.printHen(count);
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

        final Printer printer = new Printer();

        final Thread egg = new Thread(new EggThread(count, printer), "Egg");
        final Thread hen = new Thread(new HenThread(count, printer), "Hen");

        egg.start();
        hen.start();

        try {
            egg.join();
            hen.join();

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}