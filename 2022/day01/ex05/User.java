// Copyright 2025 stranger

package day01.ex05;

public class User{
    private final int id;
    private int balance;
    private final String name;

    private final TransactionsList transactions;

    public User(final String name, final int balance){
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;

        transactions = new TransactionsLinkedList();

        setBalance(balance);
    }

    public int getId(){
        return id;
    }

    public int getBalance(){
        return balance;
    }

    public String getName(){
        return name;
    }

    public void setBalance(final int balance){
        this.balance = Math.max(balance, 0);
    }

    public TransactionsList transactions(){
        return transactions;
    }
}