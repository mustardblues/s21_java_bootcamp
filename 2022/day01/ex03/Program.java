// Copyright 2025 stranger

package day01.ex03;

public class Program{
    public static void main(String[] args){
        User user1 = new User("John", 500);
        User user2 = new User("Mike", 0);

        Transaction transaction1 = new Transaction(user1, user2, -250);
        Transaction transaction2 = new Transaction(user1, user2, 250);
        Transaction transaction3 = new Transaction(user1, user2, -500);

        TransactionsLinkedList list = new TransactionsLinkedList();

        list.add(transaction1);
        list.add(transaction2);
        list.add(transaction3);

        try{
            list.delete(transaction2.getId());

            Transaction[] array = list.toArray();

            System.out.println(array.length);

            System.out.println(array[0].getSender().getName() + " " +
                    array[0].getRecipient().getName() + " " +
                    array[0].getAmount() + " " +
                    array[0].getCategory() + " " +
                    array[0].getId());

            System.out.println(array[1].getSender().getName() + " " +
                    array[1].getRecipient().getName() + " " +
                    array[1].getAmount() + " " +
                    array[1].getCategory() + " " +
                    array[1].getId());
        }
        catch(TransactionNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}