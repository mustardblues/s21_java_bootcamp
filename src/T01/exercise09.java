// Copyright 2025 stranger

package T01;

import java.util.*;

public class exercise09{
    public static void main(String[] args){
        List<String> list = userInput();

        if(list != null){
            System.out.println(findPattern(list));
        }
    }

    static List<String> userInput(){
        Scanner in = new Scanner(System.in);

        final int length = inputInt(in);

        if(length <= 0) return null;

        return inputStringList(in, length + 1);
    }

    static int inputInt(Scanner in){
        while(true){
            if(!in.hasNextInt()){
                System.out.println("Couldn't parse a number. Please, try again.");
                in.nextLine();

                continue;
            }

            final int value = in.nextInt();
            in.nextLine();

            return value;
        }
    }

    static List<String> inputStringList(Scanner in, final int length){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < length; ++i){
            list.add(in.nextLine());
        }

        return list;
    }

    static String findPattern(final List<String> list){
        StringBuilder output = new StringBuilder();

        final int index_of_last_element = list.size() - 1;

        final String pattern = list.get(index_of_last_element);

        for(int i = 0; i < index_of_last_element; ++i){
            final String line = list.get(i);

            if(line.contains(pattern)){
                output.append(", ").append(line);
            }
        }

        return output.delete(0, 2).toString();
    }
}