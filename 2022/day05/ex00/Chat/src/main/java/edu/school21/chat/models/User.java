// Copyright 2025 stranger

package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User{
    private final Long id;
    private final String login;
    private final String password;
    private final List<Chatroom> createdRooms;
    private final List<Chatroom> socializedRooms;

    public User(final Long id,
                final String login,
                final String password,
                final List<Chatroom> createdRooms,
                final List<Chatroom> socializedRooms){

        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.socializedRooms = socializedRooms;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if((obj == null) || (this.getClass() != obj.getClass())){
            return false;
        }

        final User u = (User)obj;

        return Objects.equals(this.id, u.id) &&
                Objects.equals(this.login, u.login) &&
                Objects.equals(this.password, u.password);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.login, this.password);
    }

    @Override
    public String toString(){
        return "User [id=" +
                this.id + ", login=" +
                this.login + ']';
    }
}