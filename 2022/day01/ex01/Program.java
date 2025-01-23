// Copyright 2025 stranger

package day01.ex01;

public class Program{
    public static void main(String[] args){
        User user1 = new User("John", 0);
        User user2 = new User("Mike", 0);
        User user3 = new User("Alice", 0);
        User user4 = new User("Peter", 0);

        System.out.println(user1.getId() + " " + user1.getName() + " " + user1.getBalance());
        System.out.println(user2.getId() + " " + user2.getName() + " " + user2.getBalance());
        System.out.println(user3.getId() + " " + user3.getName() + " " + user3.getBalance());
        System.out.println(user4.getId() + " " + user4.getName() + " " + user4.getBalance());

        System.out.println(UserIdsGenerator.getInstance().generateId());
    }
}