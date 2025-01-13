// Copyright 2025 stranger

import java.util.*;

public class exercise09{
    public static void main(String[] args){
        findPattern(userInput());
    }

    static List<String> userInput(){
        Scanner in = new Scanner(System.in);

        int list_size;

        while(true){
            if(!in.hasNextInt()){
                in.nextLine();

                continue;
            }

            list_size = in.nextInt();
            in.nextLine();

            break;
        }

        List<String> list = new ArrayList<>();

        if(list_size > 0){
            while(list_size-- >= 0) list.add(in.nextLine());
        }

        return list;
    }

    static void findPattern(final List<String> list){
        if(list.isEmpty()) return;

        StringBuilder output = new StringBuilder();

        final int index_of_last_element = list.size() - 1;

        final String pattern = list.get(index_of_last_element);

        for(int i = 0; i < index_of_last_element; ++i){
            final String line = list.get(i);

            if(line.contains(pattern)){
                output.append(", ").append(line);
            }
        }

        System.out.println(output.delete(0, 2));
    }
}