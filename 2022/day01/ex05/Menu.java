// Copyright 2025 stranger

package day01.ex05;

import java.util.*;

interface Method{
    void method();
}

public class Menu{
    private final int optionsNumber;
    private final String context;
    private static TransactionsService service;

    private static Scanner in;

    private final Method[] options = new Method[]{
            Menu::addUser,
            Menu::userBalance,
            Menu::preformTransfer,
            Menu::userTransactions,
            Menu::removeTransfer,
            Menu::checkTransferValidity
    };

    public Menu(final String mode){
        if(mode.equals("--profile=dev")){
            context = """
                    1. Add a user
                    2. View user balances
                    3. Perform a transfer
                    4. View all transactions for a specific user
                    5. DEV – remove a transfer by ID
                    6. DEV – check transfer validity
                    7. Finish execution
                    """;

            optionsNumber = 7;
        }
         else{
            context = """
                    1. Add a user
                    2. View user balances
                    3. Perform a transfer
                    4. View all transactions for a specific user
                    5. Finish execution
                    """;

            optionsNumber = 5;
        }

         service = new TransactionsService();

         in = new Scanner(System.in);
    }

    public void start(){
        for(int option = 0; option != optionsNumber; ){
            System.out.print(context);
            System.out.print("-> ");

            option = 0;

            if(in.hasNextInt()){
                option = in.nextInt();
            }

            in.nextLine();

            if((option > 0) && (option < optionsNumber)){
                options[option - 1].method();
            }

            System.out.println(
                    "---------------------------------------------------------");
        }
    }

    private static void addUser(){
        System.out.println("Enter a user name and a balance");
        System.out.print("-> ");

        final String[] data = in.nextLine().split(" ");

        if(data.length == 2){
            try{
                final int balance = Integer.parseInt(data[1]);

                User user = new User(data[0], balance);

                service.add(user);

                System.out.println(
                        "User with id = " + user.getId() + " is added");
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void userBalance(){
        System.out.println("Enter a user ID");
        System.out.print("-> ");

        try{
            final int id = Integer.parseInt(in.next());

            final String name = service.name(id);

            final int balance = service.balance(id);

            System.out.println(name + " - " + balance);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void preformTransfer(){
        System.out.println(
                "Enter a sender ID, a recipient ID, and a transfer amount");
        System.out.print("-> ");

        final String[] data = in.nextLine().split(" ");

        if(data.length == 3){
            try{
                final int sender_id = Integer.parseInt(data[0]);
                final int recipient_id = Integer.parseInt(data[1]);
                final int amount = Integer.parseInt(data[2]);

                service.transfer(sender_id, recipient_id, amount);

                System.out.println("The transfer is completed");
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void userTransactions(){
        System.out.println("Enter a user ID");
        System.out.print("-> ");

        try{
            final int id = Integer.parseInt(in.next());

            final Transaction[] array = service.userTransactions(id);

            for(Transaction t : array){
                if(t.getCategory() == Transaction.Category.Credit){
                    System.out.println("To " +
                            t.getRecipient().getName() + "(id = " +
                            t.getRecipient().getId() + ") " +
                            t.getAmount() + " with id = " +
                            t.getId());
                }
                else{
                    System.out.println("From " +
                            t.getSender().getName() + "(id = " +
                            t.getSender().getId() + ") " +
                            t.getAmount() + " with id = " +
                            t.getId());
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void removeTransfer(){
        System.out.println("Enter a user ID and a transfer ID");
        System.out.print("-> ");

        final String[] data = in.nextLine().split(" ");

        if(data.length != 2){
            try{
                final int user_id = Integer.parseInt(data[0]);
                final UUID transaction_id = UUID.fromString(data[1]);

                final Transaction[] array = service.userTransactions(user_id);

                for(Transaction t : array){
                    if(!transaction_id.equals(t.getId())){
                        continue;
                    }

                    if(t.getCategory() == Transaction.Category.Credit){
                        System.out.println("Transfer To " +
                                t.getRecipient() + "(id = " +
                                t.getRecipient().getId() + ") " +
                                t.getAmount() + "removed");
                    }
                    else{
                        System.out.println("Transfer From " +
                                t.getSender() + "(id = " +
                                t.getSender().getId() + ") " +
                                t.getAmount() + "removed");
                    }

                    break;
                }

                service.deleteTransaction(transaction_id, user_id);
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void checkTransferValidity(){
        try{
            final Transaction[] array = service.detectInvalidTransactions();

            for(Transaction t : array){
                if(t.getCategory() == Transaction.Category.Credit){
                    System.out.println(t.getSender().getName() +
                            "(id = " + t.getSender().getId() + ") " +
                            "has an unacknowledged transfer id " +
                            t.getId() + "to " +
                            t.getRecipient().getName() + "(id = " +
                            t.getRecipient().getId() + ") " +
                            "for " + t.getAmount());
                }
                else{
                    System.out.println(t.getRecipient().getName() +
                            "(id = " + t.getRecipient().getId() + ") " +
                            "has an unacknowledged transfer id " +
                            t.getId() + "from " +
                            t.getSender().getName() + "(id = " +
                            t.getSender().getId() + ") " +
                            "for " + t.getAmount());
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}