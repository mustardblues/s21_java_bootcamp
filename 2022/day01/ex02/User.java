// Copyright 2025 stranger

package day01.ex02;

public class User{
    private final int id;
    private int balance;
    private final String name;

    public User(final String name, final int balance){
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;

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
}