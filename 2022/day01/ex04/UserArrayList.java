// Copyright 2025 stranger

package day01.ex04;

import java.util.Arrays;

public class UserArrayList implements UserList{
    private int size;
    private User[] list;

    public UserArrayList(){
        this.list = new User[10];
        this.size = 0;
    }

    @Override
    public void add(final User user){
        if(this.size == this.list.length){
            this.list = Arrays.copyOf(this.list, this.list.length * 2);
        }

        this.list[this.size++] = user;
    }

    @Override
    public User id(final int id) throws UserNotFoundException{
        for(int i = 0; i < size; ++i){
            if(this.list[i].getId() == id){
               return this.list[i];
            }
        }

        throw new UserNotFoundException(
                "UserNotFoundException: id \"" + id + "\" not found.");
    }

    @Override
    public User index(final int index) throws UserNotFoundException{
        if((index >= 0) && (index < size)){
            return list[index];
        }

        throw new UserNotFoundException("" +
                "UserNotFoundException: the \"" + index + "\" index is out of bounds.");
    }

    @Override
    public int size(){
        return size;
    }
}