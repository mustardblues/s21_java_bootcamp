// Copyright 2025 stranger

import java.util.*;
import java.util.stream.*;

public class exercise10{
    public static void main(String[] args){
        showAdultUsers(userInput());
    }

    static List<User> userInput(){
        Scanner in = new Scanner(System.in);

        int list_size;

        while(true){
            if(!in.hasNextInt()){
                in.nextLine();

                System.out.println("Couldn't parse a number. Please, try again.");

                continue;
            }

            list_size = in.nextInt();
            in.nextLine();

            break;
        }

        List<User> list = new ArrayList<>();

        while(list_size-- > 0){
            final String name = in.next();

            in.nextLine();

            if(in.hasNextInt()){
                list.add(new User(name, in.nextInt()));
            }
            else{
                System.out.println("Incorrect input. Age <= 0.");
            }

            in.nextLine();
        }

        return list;
    }

    static void showAdultUsers(final List<User> list){
        if(list.isEmpty()) return;

        StringBuilder output = new StringBuilder();

        Stream<User> stream = list.stream();

        stream.filter(p->p.age >= 18).forEach(p->output.append(", ").append(p.name));

        System.out.println(output.delete(0, 2));
    }
}