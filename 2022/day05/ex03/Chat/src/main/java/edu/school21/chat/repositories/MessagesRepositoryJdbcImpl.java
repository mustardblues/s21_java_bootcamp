// Copyright 2025 stranger

package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
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
                        (res.getTimestamp("time") != null ?
                                res.getTimestamp("time").toLocalDateTime() :
                                null));

                return Optional.of(message);
            }
        }
        catch(SQLException ex){
            System.err.println("62: " + ex.getMessage());
            System.exit(-1);
        }

        return Optional.empty();
    }

    @Override
    public void save(Message message) throws NotSavedSubEntityException {
        if(messageValidation(message)){
            throw new NotSavedSubEntityException("Incorrect message data");
        }

        final String SQL_QUERY =
                """
                INSERT INTO chat.message (author_id, room_id, text, time)
                VALUES (?, ?, ?, ?)
                RETURNING id;
                """;

        try(final Connection connect = ds.getConnection()){
            PreparedStatement pst = connect.prepareStatement(SQL_QUERY);

            pst.setLong(1, message.getAuthor().getId());
            pst.setLong(2, message.getRoom().getId());
            pst.setString(3, message.getText());
            pst.setTimestamp(4, Timestamp.valueOf(message.getTime()));

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                message.setId(rs.getLong(1));
            }
        }
        catch(SQLException ex){
            System.err.println("97: " + ex.getMessage());
            System.exit(-1);
        }
    }

    @Override
    public void update(Message message){
        if(messageValidation(message)){
            return;
        }

        final String text = message.getText() == null ? "" : message.getText();
        final Timestamp time = message.getTime() == null ?
                null :
                Timestamp.valueOf(message.getTime());

        final String SQL_QUERY =
                """
                    UPDATE chat.message
                    SET author_id = ?, room_id = ?, text = ?, time = ?
                    WHERE id = ?;
                """;

        try(final Connection connect = ds.getConnection()){
            PreparedStatement pst = connect.prepareStatement(SQL_QUERY);

            pst.setLong(1, message.getAuthor().getId());
            pst.setLong(2, message.getRoom().getId());
            pst.setString(3, text);
            pst.setTimestamp(4, time);
            pst.setLong(5, message.getId());

            pst.executeUpdate();
        }
        catch(SQLException ex){
            System.err.println("162: " + ex.getMessage());
            System.exit(-1);
        }
    }

    private boolean messageValidation(final Message message){
        final Long user_id = message.getAuthor().getId();
        final Long room_id = message.getRoom().getId();

        if((user_id == null) || (room_id == null)){
            return true;
        }

        final String SQL_QUERY_USER =
                """
                    SELECT u.id FROM chat.user u WHERE u.id = ?;
                """;

        final String SQL_QUERY_ROOM =
                """
                    SELECT r.id FROM chat.room r WHERE r.id = ?;
                """;

        try(final Connection connect = ds.getConnection()){
            PreparedStatement pstUser = connect.prepareStatement(SQL_QUERY_USER);

            pstUser.setLong(1, message.getAuthor().getId());

            ResultSet rsUser = pstUser.executeQuery();

            if(!rsUser.next()){
                return true;
            }

            PreparedStatement pstRoom = connect.prepareStatement(SQL_QUERY_ROOM);

            pstRoom.setLong(1, message.getRoom().getId());

            ResultSet rsRoom = pstRoom.executeQuery();

            if(!rsRoom.next()){
                return true;
            }
        }
        catch(SQLException ex){
            System.err.println("139: " + ex.getMessage());
            System.exit(-1);
        }

        return false;
    }
}