// Copyright 2025 stranger

package T01;

import java.util.*;
import java.util.stream.*;

public class exercise10{
    public static void main(String[] args){
        System.out.println(detectAdultUsers(userInput()));
    }

    static List<User> userInput(){
        Scanner in = new Scanner(System.in);

        final int length = inputInt(in);

        return inputUserList(in, length);
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

    static List<User> inputUserList(Scanner in, final int length){
        List<User> users = new ArrayList<>();

        for(int i = 0; i < length; ++i){
            User new_user = new User();

            new_user.name = in.next();
            in.nextLine();

            new_user.age = inputInt(in);

            if(new_user.age > 0){
                users.add(new_user);
            }
            else{
                System.out.println("Incorrect input. Age <= 0.");
            }
        }

        return users;
    }

    static String detectAdultUsers(final List<User> users){
        StringBuilder output = new StringBuilder();

        Stream<User> stream = users.stream();

        stream.filter(p->p.age >= 18).forEach(p->output.append(", ").append(p.name));

        return output.delete(0, 2).toString();
    }
}