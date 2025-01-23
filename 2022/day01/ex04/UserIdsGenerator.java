// Copyright 2025 stranger

package day01.ex04;

public class UserIdsGenerator{
    private int id = 0;
    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();

    private UserIdsGenerator(){}

    public static UserIdsGenerator getInstance(){
        return INSTANCE;
    }

    public int generateId(){
        return ++id;
    }
}