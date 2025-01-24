// Copyright 2025 stranger

package day01.ex05;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{
    private static class Node{
        public Transaction transaction;

        public Node prev;
        public Node next;
    }

    private int size;

    private Node head;
    private Node tail;

    public TransactionsLinkedList(){
        this.head = null;
        this.tail = null;

        this.size = 0;
    }

    @Override
    public void add(final Transaction transaction){
        Node temp = new Node();

        temp.transaction = transaction;

        if(head == null){
            temp.next = null;

            head = temp;
        }
        else{
            temp.next = tail;

            tail.prev = temp;
        }

        temp.prev = null;

        tail = temp;

        ++size;
    }

    @Override
    public void delete(final UUID id) throws TransactionNotFoundException{
        Node temp = tail;

        while(temp != null){
            if(temp.transaction.getId().equals(id)){
                if(temp.next == null){
                    head = temp.prev;

                    if(head != null){
                        head.next = null;
                    }
                }
                else if(temp.prev == null){
                    tail = temp.next;

                    tail.prev = null;
                }
                else{
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                --size;

                return;
            }

            temp = temp.next;
        }

        throw new TransactionNotFoundException(
                "TransactionNotFoundException: id \"" + id + "\" not found.");
    }

    @Override
    public Transaction[] toArray(){
        Transaction[] array = new Transaction[size];

        Node temp = head;

        for(int i = 0; i < size; ++i){
            array[i] = temp.transaction;

            temp = temp.prev;
        }

        return array;
    }
}