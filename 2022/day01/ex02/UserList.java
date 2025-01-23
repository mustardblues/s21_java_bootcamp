// Copyright 2025 stranger

package day01.ex02;

public interface UserList{
    void add(final User user);

    User id(final int id) throws UserNotFoundException;

    User index(final int index) throws UserNotFoundException;
    
    int size();
}