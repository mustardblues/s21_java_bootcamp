// Copyright 2025 stranger

package edu.school21.chat.repositories;

import edu.school21.chat.models.*;

import java.util.Optional;
import java.sql.*;
import javax.sql.DataSource;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private final DataSource ds;

    public MessagesRepositoryJdbcImpl(final DataSource ds){
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id){
        final String SQL_QUERY =
                """
                    SELECT m.id, m.text, m.time,
                        u.id AS user_id, u.login, u.password,
                        r.id AS chat_id, r.name AS chat_name
                    FROM chat.message m
                    JOIN chat.user u ON m.author_id = u.id
                    JOIN chat.room r ON m.room_id = r.id
                    WHERE m.id = ?;
                """;

        try(Connection connect = ds.getConnection()){
            PreparedStatement pst = connect.prepareStatement(SQL_QUERY);

            pst.setLong(1, id);

            ResultSet res = pst.executeQuery();


            if(res.next()){
                final User user = new User(
                        res.getLong("user_id"),
                        res.getString("login"),
                        res.getString("password"),
                        null, null);

                final Chatroom room = new Chatroom(
                        res.getLong("chat_id"),
                        res.getString("chat_name"),
                        null, null);

                final Message message = new Message(
                        res.getLong("id"),
                        user,
                        room,
                        res.getString("text"),
                        res.getTimestamp("time").toLocalDateTime());

                return Optional.of(message);
            }
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            System.exit(-1);
        }

        return Optional.empty();
    }
}