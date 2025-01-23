// Copyright 2025 stranger

package day01.ex04;

public class Program{
    public static void main(String[] args){
        User user1 = new User("John", 500);
        User user2 = new User("Mike", 0);
        User user3 = new User("Alice", 500);
        User user4 = new User("Peter", 0);

        TransactionsService service = new TransactionsService();

        service.add(user1);
        service.add(user2);
        service.add(user3);
        service.add(user4);

        try{
            System.out.println(service.balance(1));
            System.out.println(service.balance(2));
            System.out.println(service.balance(3));
            System.out.println(service.balance(4));
        }
        catch(UserNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println();

        try{
            service.transaction(1, 2, 500);
            service.transaction(3, 4, 250);

            System.out.println(service.balance(1));
            System.out.println(service.balance(2));
            System.out.println(service.balance(3));
            System.out.println(service.balance(4));

            System.out.println();

            service.deleteTransaction(
                    user3.transactions().toArray()[0].getId(), 3);

            Transaction[] t1 = service.userTransactions(1);
            Transaction[] t2 = service.userTransactions(2);
            Transaction[] t4 = service.userTransactions(4);

            for(Transaction t : t1){
                System.out.println(t.getSender().getName() + " " +
                        t.getRecipient().getName() + " " +
                        t.getAmount() + " " +
                        t.getCategory() + " " +
                        t.getId());
            }

            for(Transaction t : t2){
                System.out.println(t.getSender().getName() + " " +
                        t.getRecipient().getName() + " " +
                        t.getAmount() + " " +
                        t.getCategory() + " " +
                        t.getId());
            }

            for(Transaction t : t4){
                System.out.println(t.getSender().getName() + " " +
                        t.getRecipient().getName() + " " +
                        t.getAmount() + " " +
                        t.getCategory() + " " +
                        t.getId());
            }

            System.out.println();

            Transaction[] invalidT = service.detectInvalidTransactions();

            for(Transaction t : invalidT){
                System.out.println(t.getSender().getName() + " " +
                        t.getRecipient().getName() + " " +
                        t.getAmount() + " " +
                        t.getCategory() + " " +
                        t.getId());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}