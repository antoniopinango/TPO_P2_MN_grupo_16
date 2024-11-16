package org.example.tpo;

import org.example.adt.Queue;

public class DynamicCircularDoublyLinkedQueue implements Queue {
    private DoublyNode first;
    private DoublyNode last;


    @Override
    public int getFirst() {
        if (this.isEmpty()){
            throw new RuntimeException("La cola esta vacia");
        }
        return this.first.getValue();
    }

    @Override
    public void remove() {
        if (this.isEmpty()){
            throw new RuntimeException("La cola esta vacia");
        }
        if (this.first == this.last){
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.getNext();
            this.first.setNext(this.last);
            this.last.setNext(this.first);
        }

    }

    @Override
    public void add(int value) {
        DoublyNode newNode = new DoublyNode(value, null, null);
        if (this.isEmpty()){
            this.first = newNode;
            this.last = newNode;
            this.first.setNext(this.first);
            this.first.setPrev(this.first);
        } else {
            newNode.setPrev(this.first);
            newNode.setNext(this.first);
            this.last.setNext(newNode);
            this.first.setPrev(newNode);
            this.last = newNode;
        }

    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
