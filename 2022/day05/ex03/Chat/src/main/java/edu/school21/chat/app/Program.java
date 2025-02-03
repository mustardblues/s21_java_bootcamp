// Copyright 2025 stranger

package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.*;

import java.util.*;
import com.zaxxer.hikari.HikariDataSource;

public class Program{
    public static void main(String[] args){
        try(final HikariDataSource hds = new HikariDataSource()){
            hds.setJdbcUrl("jdbc:postgresql://localhost:5432/Messenger");
            hds.setUsername("postgres");
            hds.setPassword("1488");

            MessagesRepository repos = new MessagesRepositoryJdbcImpl(hds);

            Optional<Message> optMessage = repos.findById(7L);

            if(optMessage.isPresent()){
                Message message = optMessage.get();

                message.setText("Bye bye again, sweetheart!");
                message.setTime(null);

                repos.update(message);
            }
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }
}