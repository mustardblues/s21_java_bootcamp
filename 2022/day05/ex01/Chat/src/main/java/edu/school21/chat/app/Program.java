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

            final MessagesRepository messageRepos = new MessagesRepositoryJdbcImpl(hds);

            final Scanner in = new Scanner(System.in);

            System.out.print("-> ");

            if(in.hasNextLong()){
                Optional<Message> optMessage = messageRepos.findById(in.nextLong());

                if(optMessage.isPresent()){
                    System.out.println(optMessage.get());
                }
            }
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }
}