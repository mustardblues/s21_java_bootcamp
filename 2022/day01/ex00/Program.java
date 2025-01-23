// Copyright 2025 stranger

package day01.ex00;

public class Program{
    public static void main(String[] args){
        User user1 = new User(1, "John", 500);
        User user2 = new User(2, "Mike", 0);

        System.out.println(user1.getId() + " " + user1.getName() + " " + user1.getBalance());
        System.out.println(user2.getId() + " " + user2.getName() + " " + user2.getBalance());

        System.out.println();

        Transaction transaction1 = new Transaction(user1, user2, -500);

        System.out.println(transaction1.getSender().getName() + " " +
                transaction1.getRecipient().getName() + " " +
                transaction1.getAmount() + " " +
                transaction1.getCategory() + " " +
                transaction1.getId());

        Transaction transaction2 = new Transaction(user2, user1, 500);

        System.out.println(transaction2.getSender().getName() + " " +
                transaction2.getRecipient().getName() + " " +
                transaction2.getAmount() + " " +
                transaction2.getCategory() + " " +
                transaction2.getId());
    }
}