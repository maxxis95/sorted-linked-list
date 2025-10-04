package com.ship.monk.sortedlinkedlist;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SortedLinkedList<T extends Comparable<T>> {

    @Data
    private class Node<T> {

        @Setter(AccessLevel.NONE)
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

    private Node<T> head;

    public SortedLinkedList() {
        head = null;
    }

    public void add(@NonNull T value) {
        var newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else if (head.getValue().compareTo(value) > 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            var currentNode = head;
            while (currentNode.getNext() != null && currentNode.getNext().getValue().compareTo(value) < 0) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
    }
    public void remove(@NonNull T value) {
        if (head == null) {
            return;
        }
        if (head.getValue().equals(value)) {
            head = head.getNext();
        } else {
            var currentNode = head;
            while (currentNode.getNext() != null && !currentNode.getNext().getValue().equals(value)) {
                currentNode = currentNode.getNext();
            }
            if (currentNode.getNext() != null) {
                currentNode.setNext(currentNode.getNext().getNext());
            }
        }
    }

    public Optional<List<T>> toList() {
        if (head == null) {
            Optional.empty();
        }
        var arrayList = new ArrayList<T>();
        var currentNode = head;
        while (currentNode != null) {
            arrayList.add(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        return Optional.of(arrayList);
    }

}
