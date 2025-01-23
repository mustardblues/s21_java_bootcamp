// Copyright 2025 stranger

package day01.ex03;

import java.util.UUID;

public interface TransactionsList{
    void add(final Transaction transaction);

    void delete(final UUID id) throws TransactionNotFoundException;

    Transaction[] toArray();
}