// Copyright 2025 stranger

package edu.school21.chat.app;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.*;

import java.time.LocalDateTime;
import java.util.*;
import com.zaxxer.hikari.HikariDataSource;

public class Program{
    public static void main(String[] args){
        try(final HikariDataSource hds = new HikariDataSource()){
            hds.setJdbcUrl("jdbc:postgresql://localhost:5432/Messenger");
            hds.setUsername("postgres");
            hds.setPassword("1488");

            final User user = new User(2L, "user2", "password2", new ArrayList<>(), new ArrayList<>());
            final Chatroom room = new Chatroom(2L, "chatroom2", user, new ArrayList<>());
            final Message message = new Message(null, user, room, "Hello again from user2 in room 2!", LocalDateTime.now());

            MessagesRepository repos = new MessagesRepositoryJdbcImpl(hds);
            repos.save(message);

            System.out.println(message.getId());
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }
}