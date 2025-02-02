// Copyright 2025 stranger

package edu.school21.chat.models;

import java.time.LocalDate;
import java.util.Objects;

public class Message{
    private final Long id;
    private final User author;
    private final Chatroom room;
    private final String text;
    private final LocalDate time;

    public Message(final Long id,
                   final User author,
                   final Chatroom room,
                   final String text,
                   final LocalDate time){

        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.time = time;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if((obj == null) || (this.getClass() != obj.getClass())){
            return false;
        }

        final Message m = (Message)obj;

        return Objects.equals(this.id, m.id) &&
                Objects.equals(this.author, m.author) &&
                Objects.equals(this.room, m.room) &&
                Objects.equals(this.text, m.text) &&
                Objects.equals(this.time, m.time);
    }

    @Override
    public int hashCode(){
        return Objects.hash(
                this.id,
                this.author,
                this.room,
                this.text,
                this.time);
    }

    @Override
    public String toString(){
        return "Message [id=" +
                this.id + ", author=" +
                this.author + ", room=" +
                this.room + ", text=\"" +
                this.text + "\", time=" +
                this.time + ']';
    }
}