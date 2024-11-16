package org.example.tpo;

import org.example.adt.Stack;
import org.example.adt.nodes.Node;

public class LimitedDynamicStack implements Stack {
    private Node first;
    private int size;
    private final int capacity;

    public LimitedDynamicStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a cero");
        }

        this.capacity = capacity;
        this.size = 0;
        this.first = null;
    }

    @Override
    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return this.first.getValue();
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        this.first = this.first.getNext();
        this.size--;
    }

    @Override
    public void add(int value) {
        if (this.size >= this.capacity) {
            throw new RuntimeException("La pila ha alcanzado su capacidad máxima");
        }
        this.first = new Node (value, this.first);
        this.size++;

    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    public boolean isFull(){
        return this.size >= this.capacity;
    }
    public int getSize(){
        return this.size;
    }
    public int getCapacity(){
        return this.capacity;
    }
}


