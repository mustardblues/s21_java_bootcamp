// Copyright 2025 stranger

package day01.ex03;

import java.util.UUID;

public class Transaction{
    public enum Category{
        Debit,
        Credit
    }

    private final UUID id;
    private final User sender;
    private final User recipient;
    private Category category;
    private int amount;

    public Transaction(final User sender,
                       final User recipient,
                       final int amount){
        id = UUID.randomUUID();
        this.sender = sender;
        this.recipient = recipient;

        setAmount(amount);
    }

    public UUID getId(){
        return id;
    }

    public User getSender(){
        return sender;
    }

    public User getRecipient(){
        return recipient;
    }

    public Category getCategory(){
        return category;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(final int amount){
        if((sender.getBalance() >= 0) && (amount < 0)){
            this.amount = amount;

            this.category = Category.Credit;
        }
        else if((recipient.getBalance() >= 0) && (amount > 0)){
            this.amount = amount;

            this.category = Category.Debit;
        }
    }
}