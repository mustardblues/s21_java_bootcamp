// Copyright 2025 stranger

package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;
import edu.school21.chat.exceptions.NotSavedSubEntityException;

import java.util.Optional;

public interface MessagesRepository{
    Optional<Message> findById(Long id);

    void save(Message message) throws NotSavedSubEntityException;
}