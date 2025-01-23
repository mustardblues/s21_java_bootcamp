// Copyright 2025 stranger

package day01.ex02;

public class Program{
    public static void main(String[] args){
        User user1 = new User("John", 0);
        User user2 = new User("Mike", 0);
        User user3 = new User("Alice", 0);
        User user4 = new User("Peter", 0);

        UserArrayList list = new UserArrayList();

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        try{
            User temp1 = list.id(1);
            User temp2 = list.id(2);
            User temp3 = list.index(2);
            User temp4 = list.index(3);

            System.out.println(list.size());

            System.out.println(temp1.getId() + " " + temp1.getName() + " " + temp1.getBalance());
            System.out.println(temp2.getId() + " " + temp2.getName() + " " + temp2.getBalance());
            System.out.println(temp3.getId() + " " + temp3.getName() + " " + temp3.getBalance());
            System.out.println(temp4.getId() + " " + temp4.getName() + " " + temp4.getBalance());
        }
        catch(UserNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}