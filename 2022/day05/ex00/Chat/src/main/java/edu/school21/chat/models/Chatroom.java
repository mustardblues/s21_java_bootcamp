// Copyright 2025 stranger

package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom{
    private final Long id;
    private final String name;
    private final User owner;
    private final List<Message> messages;

    public Chatroom(final Long id,
                    final String name,
                    final User owner,
                    final List<Message> message){

        this.id = id;
        this.name = name;
        this.owner = owner;
        this.messages = message;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if((obj == null) || (this.getClass() != obj.getClass())){
            return false;
        }

        final Chatroom c = (Chatroom)obj;

        return Objects.equals(this.id, c.id) &&
                Objects.equals(this.name, c.name) &&
                Objects.equals(this.owner, c.owner);
    }

    @Override
    public int hashCode(){
        return Objects.hash(
                this.id,
                this,name,
                this.owner);
    }

    @Override
    public String toString(){
        return "Chatroom [id=" +
                this.id + ", name=" +
                this.name + ", owner=" +
                this.owner + ']';
    }
}