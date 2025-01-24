// Copyright 2025 stranger

package day01.ex05;

import java.util.UUID;

public class TransactionsService{
    private final UserList user_list;

    public TransactionsService(){
        this.user_list = new UserArrayList();
    }

    public void add(final User user){
        this.user_list.add(user);
    }

    public String name(final int id) throws UserNotFoundException{
        return this.user_list.id(id).getName();
    }

    public int balance(final int id) throws UserNotFoundException{
        return this.user_list.id(id).getBalance();
    }

    public void transfer(final int sender_id,
                            final int recipient_id,
                            final int amount)
            throws UserNotFoundException, RuntimeException{
        if(amount < 0){
            throw new RuntimeException("Too small an amount to transfer");
        }

        final User sender = this.user_list.id(sender_id);
        final User recipient = this.user_list.id(recipient_id);

        if(sender.getBalance() < amount){
            throw new RuntimeException(
                   sender.getName() + " doesn't have enough amount to transfer");
        }

        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);

        final UUID id = UUID.randomUUID();

        sender.transactions().add(new Transaction(id, sender, recipient, -amount));
        recipient.transactions().add(new Transaction(id, sender, recipient, amount));
    }

    public Transaction[] userTransactions(final int id)
            throws  UserNotFoundException{
        return this.user_list.id(id).transactions().toArray();
    }

    public void deleteTransaction(final UUID transaction_id, final int user_id)
            throws  UserNotFoundException, TransactionNotFoundException{
        this.user_list.id(user_id).transactions().delete(transaction_id);
    }

    public Transaction[] detectInvalidTransactions() throws  UserNotFoundException{
        final TransactionsList list = new TransactionsLinkedList();

        for(int i = 0, size = this.user_list.size(); i < size; ++i){
            Transaction[] temp = this.user_list.index(i).transactions().toArray();

            for(Transaction t : temp){
                list.add(t);
            }
        }

        final Transaction[] array = list.toArray();
        final TransactionsList result = new TransactionsLinkedList();

        for(int i = 0; i < array.length; ++i){
            if(array[i] == null){
                continue;
            }

            final UUID temp = array[i].getId();
            int counter = 0;

            for(int j = i + 1; j < array.length; ++j){
                if(array[j] != null && array[j].getId().equals(temp)){
                    array[j] = null;

                    ++counter;

                    break;
                }
            }

            if(counter == 0){
                result.add(array[i]);
            }
        }

        return result.toArray();
    }
}